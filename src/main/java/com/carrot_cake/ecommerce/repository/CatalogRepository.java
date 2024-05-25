package com.carrot_cake.ecommerce.repository;

import com.carrot_cake.ecommerce.*;
import com.carrot_cake.ecommerce.model.Catalog;
import com.carrot_cake.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long>
{

    Optional<Product> findByMobileNumber(String mobileNumber);


}
