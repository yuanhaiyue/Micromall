package com.example.micromall.controller;


import com.example.micromall.Vo.ProductVo;
import com.example.micromall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 14760
 */
@RequestMapping("/product")
@RestController
public class ProductController {

    final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<ProductVo> selectBySubCategoryId(Integer subCategoryId){
        return productService.selectProduct(subCategoryId);
    }

    @GetMapping("/details")
    public ProductVo selectById(Integer productId){
        return productService.selectProductById(productId);
    }

}
