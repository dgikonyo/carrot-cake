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
public class Catalog extends BaseEntity
{
    @Column(name="catalog_Id")
    private Long catalogId;
    @Column(name="_number")
    private String accountType;
    @Column(name="branch_address")
    private String branchAddress;
    @Id
    private Long id;

}
