package com.example.micromall.entity;

import com.example.micromall.utils.Create;
import com.example.micromall.utils.Update;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * @author 14760
 */

@Setter
@Getter
@Entity
public class Orders {
    @NotNull(groups = Update.class)
    @Null(groups = Create.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private Integer price;

    private String contactName;
    private String contactTel;
    private String contactAddress;
    private String contactDetail;

    private String note;
    private Integer isPay;
    private Integer isCancel;

    private Date createTime;
    private Date updateTime;
    @Transient
    private Integer buyerId;

    @JsonIgnore
    @JoinColumn(name = "buyer_id")
    @ManyToOne
    private User buyer;

    @OneToMany(mappedBy = "orders")
    private Set<OrderGoods> orderGoods;


//    @JsonIgnore
//    @JoinColumn(name = "product_id")
//    @ManyToOne
//    private Product product;


    public void getBuyersId(){
        this.buyerId=buyer.getId();
    }
}
