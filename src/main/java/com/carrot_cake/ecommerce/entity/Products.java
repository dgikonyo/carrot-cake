package com.carrot_cake.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Products extends  BaseEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_Id")
    private Long product_Id;
    @Column(name="order_Id")
    private String order_Id;

}
