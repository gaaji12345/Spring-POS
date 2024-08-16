package repo;/*  gaajiCode
    99
    15/08/2024
    */

import entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {
}
