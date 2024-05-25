package com.carrot_cake.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(name = "Catalog", description = "Schema to hold Catalog information")
public class CatalogDto
{
    @NotEmpty(message = "Catalog not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Catalog must be 10 digits")
    @Schema(description = "Category ", example = "")
    private Long category;
    @Schema(description = "SubCategory ", example = "")
    private Long subcategory;


    public static CatalogDto fetchCatalog(String mobileNumber)
    {
        return null;
    }


}
