package com.nirwantech.order_service.controller;

import com.nirwantech.base_domains.dto.Order;
import com.nirwantech.base_domains.dto.OrderEvent;
import com.nirwantech.order_service.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController

@RequestMapping("/api/v1")
public class OrderController {
    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOder(Order order){
        order.setOrderId((UUID.randomUUID().toString()));
        OrderEvent orderEvent1=new OrderEvent();
        orderEvent1.setOrder(order);
        orderEvent1.setMessage("Order status is in pending state");
        orderEvent1.setStatus("Pending");

         orderProducer.sendMessage(orderEvent1);
  return  "Order place successfully!....";

    }
}
