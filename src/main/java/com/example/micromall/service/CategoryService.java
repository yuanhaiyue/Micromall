package com.example.micromall.service;

import com.example.micromall.entity.Category;
import com.example.micromall.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 14760
 */
@Service
public class CategoryService {

    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


   public List<Category> selectAll(){
        return categoryRepository.findAll();
   }

}
