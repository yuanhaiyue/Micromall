package com.example.micromall.controller;



import com.example.micromall.entity.Orders;
import com.example.micromall.service.OrderService;
import com.example.micromall.utils.CreateOrder;
import com.example.micromall.utils.JSONResult;
import com.example.micromall.utils.Results;
import lombok.Data;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 14760
 */
@RequestMapping("/order")
@RestController
@Validated
public class OrderController {

    final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/create")
    public JSONResult createOrder(@RequestBody @Validated CreateOrder createOrder){
        return orderService.createOrder(createOrder);
    }


//    @GetMapping("/details")
//    public OrderVo  selectOrder(Integer id){
//        Orders orders= orderService.selectById(id);
//        return OrderVo.filter(orders);
//    }
//
//    @GetMapping("/list")
//    public List<OrderVo> selectList(Integer buyerId){
//        return orderService.selectList(buyerId).stream().map(OrderVo::filter).collect(Collectors.toList());
//    }




}
