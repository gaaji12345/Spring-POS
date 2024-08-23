package services.impl;/*  gaajiCode
    99
    20/08/2024
    */

import dto.OrdersDTO;
import entity.Orders;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.OrderRepo;
import services.OrderService;
import services.Genarator;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    Genarator genarator;
    @Override
    public List<OrdersDTO> getAllOrders() {
        List<entity.Orders> all=orderRepo.findAll();

        return modelMapper.map(all,new TypeToken<List<OrdersDTO>>(){}.getType());
    }

    @Override
    public String createOrder() {
        String prefix = "ORD-";
        String suffix = "-ID";
        int length = 3;
        boolean includeTimestamp = true; // or false based on your needs

        return Genarator.generateOrderId(length, prefix, suffix, includeTimestamp);  }


}
