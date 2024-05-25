package com.carrot_cake.ecommerce.service;

import com.carrot_cake.ecommerce.dto.CatalogDto;
import org.springframework.stereotype.Service;


@Service
public interface CatalogService
{
    static boolean updateProduct(CatalogDto catalogDto)
    {
        return false;
    }
    static boolean deleteCatalog(String catalog)
    {
        return false;
    }
    static boolean updateCatalog(CatalogDto catalogDto) {
        return false;
    }
    void createCatalog(CatalogDto catalogDto);
    CatalogDto fetchAccount(String mobileNumber);
    boolean updateAccount(CatalogDto customerDto);
    CatalogDto fetchCatalog(String mobileNumber);
}
