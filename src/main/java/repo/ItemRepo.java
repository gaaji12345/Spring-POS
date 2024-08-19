package repo;/*  gaajiCode
    99
    17/08/2024
    */

import entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,String> {
}
