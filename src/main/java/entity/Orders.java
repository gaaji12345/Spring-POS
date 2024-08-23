package entity;/*  gaajiCode
    99
    19/08/2024
    */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Orders {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String oid;


    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "customerID",referencedColumnName = "id",nullable = false)
    private Customer cusID;
    private LocalDate date;


    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;
}
