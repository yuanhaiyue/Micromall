package com.example.micromall.service;


import com.example.micromall.entity.Product;
import com.example.micromall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 14760
 */
@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    public List<ProductVo> selectProduct(Integer subCategoryId){
//        return productRepository.selectBySubCategoryId(subCategoryId);
//    }
    public Set<Product> selectProduct(Integer subCategoryId){
        return productRepository.findProductBySubCategoryId(subCategoryId);
    }

    public Product selectProductById(Integer productId){
        return productRepository.findById(productId).get();
    }


    public Set<Product> getProduct(Integer []id){
        return Arrays.stream(id).map(productRepository::findById).map(Optional::get).collect(Collectors.toSet());
    }





}
