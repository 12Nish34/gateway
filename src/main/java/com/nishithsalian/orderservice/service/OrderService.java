package com.nishithsalian.orderservice.service;

import com.nishithsalian.orderservice.Model.Order;
import com.nishithsalian.orderservice.Model.OrderLineItem;
import com.nishithsalian.orderservice.dto.OrderLineItemsDtoList;
import com.nishithsalian.orderservice.dto.OrderRequest;
import com.nishithsalian.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void addOrder(@RequestBody OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> orderLineList = orderRequest.getOrderLineItemList().stream().
                map(orderLineItemsDto -> mapToDto(orderLineItemsDto)).toList();

        order.setOrderLineItemList(orderLineList);
        log.info("Comes here");
        orderRepository.save(order);
        log.info("Does not come here");
    }
    

    private OrderLineItem mapToDto(OrderLineItemsDtoList orderLineItemsDtoList) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setQuantity(orderLineItemsDtoList.getQuantity());
        orderLineItem.setPrice(orderLineItemsDtoList.getPrice());
        orderLineItem.setSkuCode(orderLineItemsDtoList.getSkuCode());
        return orderLineItem;
    }

}
