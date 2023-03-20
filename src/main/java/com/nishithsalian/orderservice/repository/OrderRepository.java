package com.nishithsalian.orderservice.repository;

import com.nishithsalian.orderservice.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {
}
