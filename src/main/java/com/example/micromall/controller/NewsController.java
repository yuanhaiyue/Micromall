package com.example.micromall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.micromall.entity.News;
import com.example.micromall.repository.NewsRepository;
import com.example.micromall.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author 14760
 */
@RequestMapping("/news")
@RestController
public class NewsController {
    final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

//    @GetMapping("/list")
//    public List<NewsService.NewsVo> selectAll(){
//        return newsService.selectNews();
//
//    }

    @GetMapping("/detail")
    public News selectById(Integer id){
        return newsService.selectNewsId(id);
    }

    @GetMapping("/list")
    public List<News> selectAll(){
        return newsService.selectNews();

    }




}
