package com.carrot_cake.ecommerce.mapper;

import com.carrot_cake.ecommerce.dto.CatalogDto;
import com.carrot_cake.ecommerce.model.Product;
import org.springframework.jmx.export.metadata.ManagedMetric;


public class ProductsMapper
{
    public static Long mapToProduct(Product product, CatalogDto catalogDto)
    {

        Long catalog = null;
        ManagedMetric categoryDto = new ManagedMetric();
        categoryDto.setCategory(categoryDto.getCategory());

        return catalog;
    }


}
