package com.example.micromall.repository;

import com.example.micromall.entity.OrderGoods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 14760
 */
public interface OrderGoodsRepository extends JpaRepository<OrderGoods,Integer> {
}
