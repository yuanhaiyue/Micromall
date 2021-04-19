package com.example.micromall.controller;



import com.example.micromall.service.OrderService;
import com.example.micromall.utils.CreateOrder;
import com.example.micromall.utils.JSONResult;



import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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


    @GetMapping("/details")
    public JSONResult  selectOrder(Integer id){
        return orderService.selectById(id);
    }

    @GetMapping("/list")
    public JSONResult selectList(HttpSession session){
        return orderService.selectList(session);
    }

    @PostMapping("/delete")
    public JSONResult deleteOrders(Integer id){
        return orderService.deleteOrders(id);
    }


}
