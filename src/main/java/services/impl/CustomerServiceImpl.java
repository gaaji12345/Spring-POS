package services.impl;/*  gaajiCode
    99
    15/08/2024
    */

import dto.CustomerDTO;
import entity.Customer;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.CustomerRepo;
import services.CustomerService;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO c) {

        Customer map = modelMapper.map(c, Customer.class);
        customerRepo.save(map);

    }

    @Override
    public void updateCustomer(CustomerDTO c) {

        Customer map = modelMapper.map(c, Customer.class);
        customerRepo.save(map);

    }

    @Override
    public void deleteCustomer(String id) {

        customerRepo.deleteById(id);
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {


        List<Customer> all=customerRepo.findAll();

        return modelMapper.map(all,new TypeToken<List<CustomerDTO>>(){}.getType());
    }
}
