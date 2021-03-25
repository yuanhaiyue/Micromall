package com.example.micromall.service;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.micromall.entity.News;
import com.example.micromall.repository.NewsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.List;

/**
 * @author 14760
 */
@Service
public class NewsService {
    final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

//    public List<NewsVo> selectNews(){
//        return newsRepository.select();
//    }
    public List<News> selectNews(){
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("image","id","title","hits","create_time");
        return newsRepository.selectList(queryWrapper);
    }


    public News selectNewsId(Integer id){
        News news= newsRepository.selectById(id);
        UpdateWrapper<News> updateWrapper=new UpdateWrapper<>();
        updateWrapper.set("hits",news.getHits()+1).eq("id", id);
        newsRepository.update(null,updateWrapper);
        return news;
    }
    @AllArgsConstructor
    @Data
    public static class NewsVo{

        private Integer id;
        private String image;
        private Integer hits;
        @TableField(value = "create_time")
        private Long createTime;
        private String title;

    }

}
