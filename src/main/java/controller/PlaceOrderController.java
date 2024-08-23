package controller;/*  gaajiCode
    99
    21/08/2024
    */

import dto.OrdersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.OrderDetailService;
import util.ResponceUtil;

@RestController
@RequestMapping("placeOrder")
@CrossOrigin
public class PlaceOrderController {
   @Autowired
    OrderDetailService od;

    @PostMapping()
    public ResponceUtil purchaseOrder(@RequestBody OrdersDTO dto) {
        System.out.println(dto.toString());
        od.purchaseOrder(dto);
        return new ResponceUtil(200, "Success", null);
    }
}
