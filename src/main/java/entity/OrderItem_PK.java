package entity;/*  gaajiCode
    99
    19/08/2024
    */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem_PK implements Serializable {
    private String oid;
    private String itemCode;
}
