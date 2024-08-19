package services.impl;/*  gaajiCode
    99
    17/08/2024
    */

import dto.CustomerDTO;
import dto.ItemDTO;
import entity.Customer;
import entity.Item;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.ItemRepo;
import services.ItemService;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public void saveItem(ItemDTO i) {
        Item map = modelMapper.map(i, Item.class);
        itemRepo.save(map);
    }

    @Override
    public void updateItem(ItemDTO i) {

        Item map = modelMapper.map(i, Item.class);
        itemRepo.save(map);
    }

    @Override
    public void deleteItem(String code) {
      itemRepo.deleteById(code);
    }

    @Override
    public ItemDTO searchItem(String code) {
        return null;
    }

    @Override
    public List<ItemDTO> getAllItems() {


        List<Item> all=itemRepo.findAll();

        return modelMapper.map(all,new TypeToken<List<ItemDTO>>(){}.getType());
    }
}
