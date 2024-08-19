package services;/*  gaajiCode
    99
    17/08/2024
    */

import dto.CustomerDTO;
import dto.ItemDTO;

import java.util.List;

public interface ItemService {
     void saveItem(ItemDTO i);

     void updateItem(ItemDTO i);

     void deleteItem(String code);

     ItemDTO searchItem(String code);


     List<ItemDTO> getAllItems();
}
