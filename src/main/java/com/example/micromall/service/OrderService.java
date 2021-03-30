package com.example.micromall.service;


import com.example.micromall.controller.OrderController;
import com.example.micromall.entity.Contact;
import com.example.micromall.entity.Orders;
import com.example.micromall.entity.Product;
import com.example.micromall.entity.User;
import com.example.micromall.repository.ContactRepository;
import com.example.micromall.repository.OrderRepository;
import com.example.micromall.repository.ProductRepository;
import com.example.micromall.repository.UserRepository;
import com.example.micromall.utils.CreateOrder;
import com.example.micromall.utils.JSONResult;
import com.example.micromall.utils.Results;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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

    public OrderService(OrderRepository repository, UserRepository userRepository, ProductRepository productRepository, ContactRepository contactRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.contactRepository = contactRepository;
    }

    public Orders selectById(Integer id){
        return repository.findById(id).get();

    }

    public JSONResult createOrder(CreateOrder createOrder){
        Contact contact=contactRepository.selectById(createOrder.getContactId());
        Set<CreateOrder.OrderCreateGoods> orderCreateGoods =CreateOrder.OrderCreateGoods.getCreateGoods(createOrder.getGoods(),productRepository);
        User user=contact.getUser();
        Orders orders=new Orders(contact,orderCreateGoods,user);
        Orders ordersTwo=repository.save(orders);

        if (ordersTwo!=null){
            return JSONResult.ok("","创建成功");
        }
        return JSONResult.errorMsg("创建失败");

    }
    public List<Orders> selectList(Integer buyerId){
        return repository.findByBuyer_Id(buyerId);

    }

}
