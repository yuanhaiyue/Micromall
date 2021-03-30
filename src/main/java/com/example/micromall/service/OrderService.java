package com.example.micromall.service;


import com.example.micromall.controller.OrderController;
import com.example.micromall.entity.Orders;
import com.example.micromall.entity.Product;
import com.example.micromall.entity.User;
import com.example.micromall.repository.OrderRepository;
import com.example.micromall.repository.ProductRepository;
import com.example.micromall.repository.UserRepository;
import com.example.micromall.utils.CreateOrder;
import com.example.micromall.utils.Results;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 14760
 */
@Service
public class OrderService {

    final OrderRepository repository;
    final UserRepository userRepository;
    final ProductRepository productRepository;

    public OrderService(OrderRepository repository, UserRepository userRepository, ProductRepository productRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public Orders selectById(Integer id){
        return repository.findById(id).get();

    }

    public Results createOrder(CreateOrder createOrder){

        return  new Results("创建订单失败", 400);

    }
    public List<Orders> selectList(Integer buyerId){
        return repository.findByBuyer_Id(buyerId);

    }

}
