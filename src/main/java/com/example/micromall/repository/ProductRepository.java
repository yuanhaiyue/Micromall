package com.example.micromall.repository;

import com.example.micromall.Vo.ProductVo;
import com.example.micromall.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 14760
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {



    @Query(value = "select new com.example.micromall.Vo.ProductVo(p.parameter,p.id,p.price,p.details,p.name,p.image,sub.name,sub.id) " +
            "from Product p,SubCategory sub where p.subCategory.id=sub.id and p.subCategory.id=:id" )
    List<ProductVo> selectBySubCategoryId(@Param(value = "id") Integer subCategoryId);

    @Query(value = "select new com.example.micromall.Vo.ProductVo(p.parameter,p.id,p.price,p.details,p.name,p.image,p.subCategory.name,p.subCategory.id) " +
            "from Product p where  p.id=:id" )
    ProductVo selectById(@Param(value = "id") Integer productId);
}
