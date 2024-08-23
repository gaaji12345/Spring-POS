package services.impl;/*  gaajiCode
    99
    21/08/2024
    */

import dto.OrderDetailDTO;
import dto.OrdersDTO;
import entity.Item;
import entity.OrderDetails;
import entity.Orders;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.ItemRepo;
import repo.OrderDetailsRepo;
import repo.OrderRepo;
import services.OrderDetailService;

import java.util.List;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderRepo ordersRepo;


    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void purchaseOrder(OrdersDTO dto) {
//        if (ordersRepo.existsById(dto.getOid())) throw new RuntimeException("exist order id");
//
//        // Orders table & OrderDetails table
//        ordersRepo.save(mapper.map(dto, Orders.class));
//
//        // Update item qty
//        List<OrderDetailDTO> orderDetails = dto.getOrderDetails();
//        for (OrderDetailDTO detailsDTO : orderDetails) {
//            String itemCode = detailsDTO.getItemCode();
//
//            // get current item qty
//            Item item = itemRepo.findById(itemCode).orElseThrow(() -> new RuntimeException("Item not found with code: " + itemCode));
//            int qtyOnHand = item.getQtyOnHand();
//
//            // update qty
//            int updatedQty = qtyOnHand - detailsDTO.getQty();
//
//            // check if not updatedQty is - value
//            if (updatedQty >= 0) {
//                item.setQtyOnHand(updatedQty);
//                itemRepo.save(item);
//            } else {
//                throw new RuntimeException("Wrong item count in " + itemCode);
//            }
//
//        }
        Orders order=mapper.map(dto,Orders.class);

        if (!ordersRepo.existsById(dto.getOid())){
            if (dto.getOrderDetails().size() < 1) throw new RuntimeException("No Item Added");
            for (OrderDetails orderDetails : order.getOrderDetails()){
                Item item =itemRepo.findById(orderDetails.getItemCode()).get();
                item.setQtyOnHand(item.getQtyOnHand() -orderDetails.getQty());
                itemRepo.save(item);

            }
        }else {
            throw new RuntimeException("Purdhed Failed"+dto.getOid());
        }

    }
    }

