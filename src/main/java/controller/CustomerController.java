package controller;/*  gaajiCode
    99
    15/08/2024
    */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {


    @GetMapping
    public String get(){
        return "Hii Gaaaji";
    }



}
