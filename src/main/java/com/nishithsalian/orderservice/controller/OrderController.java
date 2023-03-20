package com.nishithsalian.orderservice.controller;

import com.nishithsalian.orderservice.dto.OrderRequest;
import com.nishithsalian.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/order")
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.addOrder(orderRequest);
        log.info("Order has been placed!!");
    }
}
