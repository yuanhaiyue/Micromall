package com.example.micromall.service;


import com.example.micromall.Vo.ProductVo;
import com.example.micromall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 14760
 */
@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductVo> selectProduct(Integer subCategoryId){
        return productRepository.selectBySubCategoryId(subCategoryId);
    }

    public ProductVo selectProductById(Integer productId){
        return productRepository.selectById(productId);
    }






}
