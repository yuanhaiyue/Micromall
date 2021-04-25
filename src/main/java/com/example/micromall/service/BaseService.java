package com.example.micromall.service;

import java.util.List;

/**
 * 基础接口
 * @author 14760
 */
public interface BaseService<T> {

    /**
     * 查找所有信息
     * @return list<baseEntity></>
     */
    List<T> list();

    /**
     *
     * @value 根据 ID 查询
     */
    T getId(Long id);

    /**
     * 删除
     ** @param baseEntity 基类对象
     */
    boolean delete(T baseEntity);

    /**
     *修改
     * @param baseEntity 基类对象
     */
    boolean update(T baseEntity);

    /**
     * 增加
     * @param baseEntity 基类对象
     */
    boolean insert(T baseEntity);

}