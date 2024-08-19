package controller;/*  gaajiCode
    99
    17/08/2024
    */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.ItemService;
import util.ResponceUtil;

@RestController
@RequestMapping("item")
@CrossOrigin
public class ItemController {


     @Autowired
    ItemService itemService;

    @GetMapping
    public ResponceUtil getAllItems(){

        return new ResponceUtil(200,"OK",itemService.getAllItems());
    }


}
