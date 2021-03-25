package com.example.micromall.repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.micromall.entity.News;
import com.example.micromall.service.NewsService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 14760
 */
@Mapper
@Repository
public interface NewsRepository extends BaseMapper<News> {
    @Select("select id,image,hits,create_time,title from news ")
    List<NewsService.NewsVo> select();

}
