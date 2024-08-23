package services;/*  gaajiCode
    99
    20/08/2024
    */

import dto.OrdersDTO;

import java.util.List;

public interface OrderService {
    List<OrdersDTO> getAllOrders();

    public String createOrder();
}
