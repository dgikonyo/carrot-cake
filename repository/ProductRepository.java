package com.carrot_cake.ecommerce.repository;

import com.carrot_cake.ecommerce.*;
import com.carrot_cake.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{

    Optional<Product> findByMobileNumber(String mobileNumber);


}
