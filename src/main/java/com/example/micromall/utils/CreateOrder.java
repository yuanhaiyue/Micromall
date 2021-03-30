package com.example.micromall.utils;

import com.example.micromall.entity.Product;
import com.example.micromall.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 14760
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class CreateOrder{

    private Integer contactId;
    private String note;
    private Set<Goods> goods;





    @Data
    public static class Goods{
        private Integer id;
        private Integer count;
        private boolean selected;


    }
    @Data
    public static class OrderCreateGoods{
        private Product products;
        private Integer count;
        private boolean selected;

        public static Set<OrderCreateGoods> getCreateGoods(Set<Goods> goods, ProductRepository productRepository){
            Set<OrderCreateGoods> goodsSet=new HashSet<>();
            for (Goods g:goods){
                OrderCreateGoods createGoods=new OrderCreateGoods();
                createGoods.setCount(g.getCount());
                createGoods.setSelected(g.isSelected());
                createGoods.setProducts(productRepository.findById(g.getId()).get());
                goodsSet.add(createGoods);
            }
            return goodsSet;
        }
    }

}
