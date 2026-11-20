package com.vingapfc.superapp.orderservice.repository;

import com.vingapfc.superapp.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}