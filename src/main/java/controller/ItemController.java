package controller;/*  gaajiCode
    99
    17/08/2024
    */

import dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public ResponceUtil saveItem(@ModelAttribute ItemDTO i){
        itemService.saveItem(i);
        return new ResponceUtil(200, "successfully added", i);
    }

    @PutMapping()
    public  ResponceUtil  updateItem(@RequestBody  ItemDTO i){
        itemService.updateItem(i);
        return new ResponceUtil(200,"Updated",null);

    }


    @DeleteMapping
    public  ResponceUtil deleteItem(@RequestParam("code") String code){
    itemService.deleteItem(code);
        return new ResponceUtil(200,"Deleted",null);

    }


}
