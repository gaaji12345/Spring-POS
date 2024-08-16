package services;/*  gaajiCode
    99
    15/08/2024
    */

import dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    public void saveCustomer(CustomerDTO c);

    public void updateCustomer(CustomerDTO c);

    public void deleteCustomer(String id);

    public CustomerDTO searchCustomer(String id);


    public List<CustomerDTO> getAllCustomers();
}
