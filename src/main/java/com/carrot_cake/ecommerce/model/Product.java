package com.carrot_cake.ecommerce.model;

import com.carrot_cake.ecommerce.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity
{
    @Column(name="product_Id")
    private Long prodcutId;
    @Column(name="account_number")
    @Id
    private Long accountNumber;
    @Column(name="account_type")
    private String accountType;
    @Column(name="branch_address")
    private String branchAddress;
}
