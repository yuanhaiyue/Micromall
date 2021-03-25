package com.example.micromall.repository;

import com.example.micromall.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 14760
 */
@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {

    List<Orders> findByBuyer_Id(Integer buyer_id);


}
