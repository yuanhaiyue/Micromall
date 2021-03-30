package com.example.micromall.controller;


import com.example.micromall.entity.Category;
import com.example.micromall.service.CategoryService;
import com.example.micromall.utils.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 14760
 */
@RestController
@RequestMapping("/category")
public class SubCategoryController {

    final CategoryService categoryService;

    public SubCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/list")
    public JSONResult selectAll(){
        return JSONResult.ok(categoryService.selectAll());
    }


}
