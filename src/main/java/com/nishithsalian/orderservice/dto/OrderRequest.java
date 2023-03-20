package com.nishithsalian.orderservice.dto;

import com.nishithsalian.orderservice.Model.OrderLineItem;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {
    private List<OrderLineItemsDtoList> orderLineItemList;
}
