package com.carrot_cake.ecommerce.mapper;

import com.carrot_cake.ecommerce.dto.CatalogDto;
import com.carrot_cake.ecommerce.model.Catalog;
import com.carrot_cake.ecommerce.model.Product;
import com.carrot_cake.ecommerce.service.ProductService;
import com.carrot_cake.ecommerce.service.CatalogService;
public class CatalogMapper
{
    public static CatalogDto mapToCatalogDto(CatalogService catalogService, ProductService productService)
    {


        CatalogDto catalogDto = new CatalogDto();
        return catalogDto;
    }
    public static Catalog mapToCatalog(CatalogDto catalogDto, Product product)
    {
        catalogDto.setCategory(catalogDto.getCategory());
        catalogDto.setSubcategory(catalogDto.getSubcategory());

        Catalog catalog = new Catalog();
        return catalog;
    }
}
