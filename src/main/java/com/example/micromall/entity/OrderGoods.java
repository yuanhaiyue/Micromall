package com.example.micromall.entity;

import com.example.micromall.utils.CreateOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 14760
 */
@Getter
@Setter
@Entity
public class OrderGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Transient
    private Integer ordersId;

    @Transient
    private Integer productId;

    private Integer count;

    private Integer price;

    private Date createTime;

    private Date updateTime;

    @JsonIgnoreProperties(value = {"id"})
    @ManyToOne
    private Product product;

    @Transient
    private Map<String,Object> goods;

//    @JsonIgnoreProperties(value = {"price","contactName","contactTel","contactAddress",
//            "contactDetail","note","isPay","isCancel","createTime",
//            "updateTime"})
    @JsonIgnore
    @ManyToOne
    private Orders orders;

    public void getOrdersProductId(){
        this.ordersId=orders.getId();
        this.productId=product.getId();
    }


    public OrderGoods(){

    }
    public static Set<OrderGoods> setOrderGoods(Set<CreateOrder.OrderCreateGoods> orderCreateGoods){
        Set<CreateOrder.OrderCreateGoods> orderGoodsSet=new HashSet<>();
        Set<OrderGoods> goodsSet=new HashSet<>();
        for (CreateOrder.OrderCreateGoods goods:orderGoodsSet){
            OrderGoods orderGoods=new OrderGoods();
            Product product= goods.getProducts();
            orderGoods.setProduct(product);
            orderGoods.setCount(goods.getCount());
            orderGoods.setCreateTime(new Date(System.currentTimeMillis()));
            orderGoods.setPrice(product.getPrice());
            goodsSet.add(orderGoods);
        }


        return goodsSet;
    }

}
