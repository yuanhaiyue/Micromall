package com.example.micromall.controller;



import com.example.micromall.entity.Product;
import com.example.micromall.service.ProductService;
import com.example.micromall.utils.JSONResult;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public JSONResult selectSubCategoryId(@RequestParam("category_id") Integer subCategoryId, @RequestParam("last_id") Integer lastId){
        return JSONResult.ok(productService.selectProduct(subCategoryId).stream().map(ProductVo::change).collect(Collectors.toSet()),"");
    }


//    @GetMapping("/lists")
//    public JSONResult selectSubCategoryId(Integer category_id){
//
//        return JSONResult.ok(productService.selectProduct(category_id).stream().map(ProductVo::change).collect(Collectors.toList() ),"");
//    }



    @GetMapping("/details")
    public JSONResult selectById(@RequestParam(value = "id") Integer productId){
        return JSONResult.ok(productService.selectProductById(productId));
    }

    @GetMapping("/cart")
    public JSONResult selectByIds(@RequestParam(value = "ids") Integer [] productId){
        return JSONResult.ok(productService.getProduct(productId).stream().map(ProductVo::changeTwo).collect(Collectors.toSet()));
    }

    @Setter
    @Getter
    public static class ProductVo {


        private Integer id;
        private Integer subCategoryId;
        private String name;
        private String sellPoint;
        private Integer price;
        private Integer num;
        private String image;
        private String content;
        private Integer status;
        private String album;


        private Date deleteTime;
        private Date createTime;
        private Date updateTime;

        public ProductVo(Integer id, Integer subCategoryId, Integer price, Integer num, Integer status, Product product){
            this(product.getName(),product.getSellPoint(),product.getImage(),product.getContent(),product.getAlbum().size()!=0?product.getAlbum().get(0).getImg():"");

            this.id=id;
            this.subCategoryId=subCategoryId;
            this.price=price;
            this.num=num;
            this.status=status;
        }
        private ProductVo(Date deleteTime,Date createTime,Date updateTime,Product product){
            this(product.getId(),product.getSubCategory().getId(),product.getPrice(),product.getNum(),product.getStatus(),product);
            this.deleteTime=deleteTime;
            this.createTime=createTime;
            this.updateTime=updateTime;
        }
        private ProductVo(String name,String sellPoint,String image,String content,String album){
            this.name=name;
            this.sellPoint=sellPoint;
            this.image=image;
            this.content=content;
            this.album=album;
        }
        public ProductVo(){}
        public ProductVo(Product product){
            this(product.getDeleteTime(),product.getCreateTime(),product.getUpdateTime(),product);
        }
        public static ProductVo change(Product product){
            product.setContent("");
            product.setSellPoint("");
            ProductVo p=new ProductVo(product);
            return p;
        }
        public static ProductVo changeTwo(Product product){
            return new ProductVo(product);
        }
    }

}
