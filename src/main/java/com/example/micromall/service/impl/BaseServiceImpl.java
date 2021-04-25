

package com.example.micromall.service.impl;



import com.example.micromall.entity.BaseEntity;
import com.example.micromall.repository.BaseRepository;
import com.example.micromall.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 基础服务类，所有Service都要继承
 * @author 14760
 */
public abstract class BaseServiceImpl<M extends BaseRepository<T>, T extends BaseEntity> implements BaseService<T> {
    @Autowired
    protected M baseRepository;

    /**
     * 查找所有信息
     * @return list<baseEntity></>
     */
    @Override
    public List<T> list() {
        return baseRepository.findAll();
    }

    /**
     * 根据 ID 查询
     */
    @Override
    public T getId(Long id) {
        Optional<T> baseEntity = baseRepository.findById(id);
        return baseEntity.orElse(null);
    }

    /**
     * 删除
     ** @param baseEntity 基类对象
     */
    @Override
    public boolean delete(T baseEntity) {
        //id是否存在
        if(this.baseRepository.existsById(baseEntity.getId())) {
            this.baseRepository.delete(baseEntity);
            return true;
        }
        return false;
    }

    /**
     *修改
     * @param baseEntity 基类对象
     */
    @Override
    public boolean update(T baseEntity) {
        //id是否存在
        if(this.baseRepository.existsById(baseEntity.getId())) {
            this.baseRepository.save(baseEntity);
            return true;
        }
        return false;
    }

    /**
     * 增加
     * @param baseEntity 基类对象
     */
    @Override
    public boolean insert(T baseEntity) {
        this.baseRepository.saveAndFlush(baseEntity);
        return true;
    }

  public static Pageable initPage(Map<String, Object> params) {
    Integer page = params.get("page") == null ? 1 : Integer.parseInt((String) params.get("page"));
    Integer size = params.get("size") == null ? 10 : Integer.parseInt((String) params.get("size"));

    return PageRequest.of(page - 1, size);
  }
}