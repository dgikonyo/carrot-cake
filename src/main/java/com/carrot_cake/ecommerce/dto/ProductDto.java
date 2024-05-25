package com.carrot_cake.ecommerce.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

// PRODUCT SERVICE
//
//Tracks stock availability in real-time,
//manages reordering to maintain optimal stock levels,
//and prevents overselling by coordinating with the Order Management Service.
//It can also generate alerts for low stock and initiate automated purchase orders from suppliers to ensure product availability.
//Additionally, the Inventory Service can track product lifecycles,
//including product expiration dates or product variants nearing obsolescence

@Data
@Schema(name = "Product", description = "Schema to hold Customer and Account information")
public class ProductDto
{

    @Schema(description = "Name of the product", example = "Carrot cake")
    @NotEmpty(message = "Product name can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the product name should be between 5 and 30")
    private String productname;
    @Size(min = 5, max = 30, message = "The length of the product name should be between 5 and 30")
    private String productid;
    @Size(min = 5, max = 30, message = "The length of the product name should be between 5 and 30")
    private String orderid;
    @Size(min = 5, max = 30, message = "")
    private String productalerts;
    @Schema(description = "Mobile Number of the customer", example = "254702343223")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;
    @Schema(description = "Product Details of the Product")
    private ProductDto productsDto;


    public static ProductDto fetchProduct(String mobileNumber)
    {

        ProductDto product = new ProductDto();
        return product;}
}
