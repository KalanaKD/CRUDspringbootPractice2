package com.kd.product.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    private Integer id;
    private Integer productId;
    private String productName;
    private String productDescription;
    private Integer productPrice;

}
