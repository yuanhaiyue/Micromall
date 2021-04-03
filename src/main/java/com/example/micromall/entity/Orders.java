package com.example.micromall.entity;

import com.example.micromall.utils.Create;
import com.example.micromall.utils.CreateOrder;
import com.example.micromall.utils.Update;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

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

    @OneToMany(mappedBy = "orders",cascade = {CascadeType.REMOVE,CascadeType.PERSIST},fetch = FetchType.EAGER)
    private Set<OrderGoods> orderGoods;


//    @JsonIgnore
//    @JoinColumn(name = "product_id")
//    @ManyToOne
//    private Product product;

    public Orders(Contact contact, Set<OrderGoods> orderGoods, User user){
        this.buyer=user;

        this.orderGoods=orderGoods;
        this.price=orderGoods.stream().mapToInt(x->x.getPrice()*x.getCount()).sum();
        this.contactName=contact.getName();
        this.contactTel=contact.getPhoneNumber();
        this.contactAddress=contact.getDetail();
        this.note="";
        this.isCancel=0;
        this.isCancel=0;
        this.createTime=new Date(System.currentTimeMillis());
        this.updateTime=null;
    }
    public static Orders getOrders(Contact contact, Set<CreateOrder.OrderCreateGoods> orderCreateGoods, User user){

        Set<OrderGoods> orderGoods=OrderGoods.setOrderGoods(orderCreateGoods);
        Orders orders=new Orders(contact,orderGoods,user);
        orderGoods.forEach(x->x.setOrders(orders));
        return orders;
    }
    public Orders() {

    }

    public void getBuyersId(){
        this.buyerId=buyer.getId();
    }
}
