package com.example.micromall.controller;



import com.example.micromall.entity.Orders;
import com.example.micromall.service.OrderService;
import com.example.micromall.utils.CreateOrder;
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
    public Results createOrder(@RequestBody @Validated CreateOrder createOrder){
       return orderService.createOrder(createOrder);
    }
    @GetMapping("/details")
    public OrderVo  selectOrder(Integer id){
        Orders orders= orderService.selectById(id);
        return OrderVo.filter(orders);
    }

    @GetMapping("/list")
    public List<OrderVo> selectList(Integer buyerId){
        return orderService.selectList(buyerId).stream().map(OrderVo::filter).collect(Collectors.toList());
    }



    @Data
    public static class OrderVo{
        private String state;
        private String remarks;
        private Integer freight;
        private Integer amount;
        private Integer createTime;
        private OrderBuyer buyer;
        private OrderProduct product;

        public static OrderVo filter(Orders orders){
            OrderVo orderVo=new OrderVo();
            orderVo.setState(orders.getStates());
            orderVo.setAmount(orders.getAmount());
            orderVo.setRemarks(orders.getRemarks());
            orderVo.setFreight(orders.getFreight());
            orderVo.setCreateTime(orders.getCreateTime());
            OrderBuyer buyer=new OrderBuyer();
            buyer.setId(orders.getBuyer().getId());
            buyer.setName(orders.getBuyer().getName());
            OrderProduct product=new OrderProduct();
            product.setId(orders.getProduct().getId());
            product.setName(orders.getProduct().getName());
            orderVo.setBuyer(buyer);
            orderVo.setProduct(product);
            return orderVo;
        }



    }
    @Data
    private static class OrderBuyer{
        private Integer id;
        private String name;
    }
    @Data
    private static class OrderProduct{
        private Integer id;
        private String name;
    }
}
