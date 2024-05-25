package com.carrot_cake.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
public class Catalog
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="catalog_id")
    private Long catalogId;
    private String firstname;
    private String lastname;
    private String email;
    private String postalAddress;
    @Column (name="mobile_number")
    private String mobileNumber;
}
