package com.example.micromall.service;


import com.example.micromall.controller.OrderController;
import com.example.micromall.entity.*;
import com.example.micromall.repository.*;
import com.example.micromall.utils.CreateOrder;
import com.example.micromall.utils.JSONResult;
import com.example.micromall.utils.Results;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 14760
 */
@Service
public class OrderService {

    final OrderRepository repository;
    final UserRepository userRepository;
    final ProductRepository productRepository;
    final ContactRepository contactRepository;
    final OrderGoodsRepository orderGoodsRepository;

    public OrderService(OrderRepository repository, UserRepository userRepository, ProductRepository productRepository, ContactRepository contactRepository, OrderGoodsRepository orderGoodsRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.contactRepository = contactRepository;
        this.orderGoodsRepository = orderGoodsRepository;
    }



    public JSONResult createOrder(CreateOrder createOrder){
        Contact contact=contactRepository.selectById(createOrder.getContactId());
        Set<CreateOrder.OrderCreateGoods> orderCreateGoods =CreateOrder.OrderCreateGoods.getCreateGoods(createOrder.getGoods(),productRepository);
        User user=userRepository.findById(contact.getUserId()).get();
        Orders orders=new Orders(contact,orderCreateGoods,user);
        orders.setNote(createOrder.getNote());
        Orders ordersTwo=repository.save(orders);
//        orderGoodsRepository.saveAll(orders.getOrderGoods());
        if (ordersTwo!=null){
            return JSONResult.ok("","创建成功");
        }
        return JSONResult.errorMsg("创建失败");

    }
//    public List<Orders> selectList(Integer buyerId){
//        return repository.findByBuyer_Id(buyerId);
//
//    }

    public JSONResult selectList(){
        List<Orders> ordersList=repository.findByBuyer_Id(1);
        for (Orders o:ordersList){
            o.getBuyersId();
            Set<OrderGoods> orderGoods=o.getOrderGoods();
            orderGoods.forEach(x->{
                x.getOrdersProductId();
                Map<String,Object> productMap=new HashMap<>();
                productMap.put("productId",x.getProduct().getId() );
                productMap.put("image", x.getProduct().getImage());
                x.setGoods(productMap);
            });

        }
        return JSONResult.ok(ordersList,"");
    }

    public JSONResult selectById(Integer id){
        Orders orders=repository.findById(id).get();

            orders.getBuyersId();
            Set<OrderGoods> orderGoods=orders.getOrderGoods();
            orderGoods.forEach(x->{
                x.getOrdersProductId();
                Map<String,Object> productMap=new HashMap<>();
                productMap.put("productId",x.getProduct().getId() );
                productMap.put("image", x.getProduct().getImage());
                productMap.put("name", x.getProduct().getName());
                x.setGoods(productMap);
            });


        return JSONResult.ok(orders,"");
    }

    public JSONResult deleteOrders(Integer id){
        repository.deleteById(id);
        return JSONResult.ok("","取消成功");
    }

}
