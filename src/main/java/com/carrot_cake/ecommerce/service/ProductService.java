package com.carrot_cake.ecommerce.service;
import com.carrot_cake.ecommerce.dto.CatalogDto;
import com.carrot_cake.ecommerce.dto.ProductDto;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {


    void createProduct(ProductDto productDto);


    ProductDto fetchProduct(String mobileNumber);


    boolean updateProduct(ProductDto productDto);

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of Account details is successful or not
     */
    boolean deletePrdouct(String mobileNumber);


    boolean deleteProduct(ProductDto productDto);

    void productCatalog(Object productServiceDto);
}
