package com.example.micromall.repository;


import com.example.micromall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author 14760
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{


    Set<Product> findProductBySubCategoryId(Integer subCategoryId);
}
