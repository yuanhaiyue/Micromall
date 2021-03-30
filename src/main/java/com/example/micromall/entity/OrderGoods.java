package com.example.micromall.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Map;

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

}
