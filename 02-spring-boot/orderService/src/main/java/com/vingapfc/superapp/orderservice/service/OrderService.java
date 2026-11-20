package com.vingapfc.superapp.orderservice.service;

import com.vingapfc.superapp.orderservice.client.ProductClient;
import com.vingapfc.superapp.orderservice.client.ProductClient.ProductDto;
import com.vingapfc.superapp.orderservice.entity.Order;
import com.vingapfc.superapp.orderservice.entity.OrderItem;
import com.vingapfc.superapp.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    public OrderService(OrderRepository orderRepository, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }

    public record CreateOrderItemRequest(Long productId, Integer quantity) {}
    public record CreateOrderRequest(String customerName, List<CreateOrderItemRequest> items) {}

    @Transactional
    public Order create(CreateOrderRequest request) {
        Order order = new Order();
        order.setCustomerName(request.customerName());

        double total = 0.0;
        for (CreateOrderItemRequest itemReq : request.items()) {
            ProductDto product = productClient.getProductById(itemReq.productId());
            if (product == null) {
                throw new IllegalArgumentException("Không tìm thấy Product với id = " + itemReq.productId());
            }

            OrderItem item = new OrderItem();
            item.setProductId(product.id());
            item.setProductName(product.name());
            item.setQuantity(itemReq.quantity());
            item.setUnitPrice(product.price());

            order.addItem(item);
            total += product.price() * itemReq.quantity();
        }

        order.setTotalAmount(total);
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy Order với id = " + id));
    }
    @Transactional
    public Order update(Long id, CreateOrderRequest request) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy Order với id = " + id));

        order.setCustomerName(request.customerName());
        order.getItems().clear();

        double total = 0.0;
        for (CreateOrderItemRequest itemReq : request.items()) {
            ProductDto product = productClient.getProductById(itemReq.productId());
            if (product == null) {
                throw new IllegalArgumentException("Không tìm thấy Product với id = " + itemReq.productId());
            }

            OrderItem item = new OrderItem();
            item.setProductId(product.id());
            item.setProductName(product.name());
            item.setQuantity(itemReq.quantity());
            item.setUnitPrice(product.price());

            order.addItem(item);
            total += product.price() * itemReq.quantity();
        }

        order.setTotalAmount(total);
        return orderRepository.save(order);
    }

    @Transactional
    public void delete(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new IllegalArgumentException("Không tìm thấy Order với id = " + id);
        }
        orderRepository.deleteById(id);
    }
}