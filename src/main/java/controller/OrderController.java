package controller;/*  gaajiCode
    99
    20/08/2024
    */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.OrderService;
import util.ResponceUtil;

@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController {


    @Autowired
    OrderService orderService;
    @GetMapping
    public ResponceUtil getAllOrders(){

        return new ResponceUtil(200,"OK",orderService.getAllOrders());
    }
    @GetMapping("/generate")
    public String generateOrderId() {
        // Use the service to generate and return the order ID
        String orderId = orderService.createOrder();
        return "Generated Order ID: " + orderId;
    }
}
