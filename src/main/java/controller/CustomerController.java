package controller;/*  gaajiCode
    99
    15/08/2024
    */

import dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.CustomerService;
import util.ResponceUtil;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {



    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponceUtil getAlCsutomer(){

        return new ResponceUtil(200,"OK",customerService.getAllCustomers());
    }

    @PostMapping
    public ResponceUtil saveCustomer(@ModelAttribute CustomerDTO c){
//        customerService.saveCustomer(c);
//        return new ResponceUtil(200,"OK",null);
        customerService.saveCustomer(c);
        return new ResponceUtil(200, "successfully added", c);
    }

    @PutMapping()
    public  ResponceUtil  updateCustomer(@RequestBody  CustomerDTO c){
        customerService.updateCustomer(c);
        return new ResponceUtil(200,"Updated",null);

    }


    @DeleteMapping
    public  ResponceUtil deletCustomer(@RequestParam("id") String id){
        customerService.deleteCustomer(id);
        return new ResponceUtil(200,"Deleted",null);

    }

    @GetMapping(path = "/{id}")
    public ResponceUtil  searchCustomer(@PathVariable("id") String id){

        return new ResponceUtil(200,"OK", customerService.searchCustomer(id));


    }





}
