package com.carrot_cake.ecommerce.service.impl;

import com.carrot_cake.ecommerce.constants.CatalogConstants;
import com.carrot_cake.ecommerce.constants.ProductConstants;
import com.carrot_cake.ecommerce.dto.CatalogDto;
import com.carrot_cake.ecommerce.dto.ErrorResponseDto;
import com.carrot_cake.ecommerce.dto.ProductDto;
import com.carrot_cake.ecommerce.dto.ResponseDto;
import com.carrot_cake.ecommerce.model.Catalog;
import com.carrot_cake.ecommerce.service.CatalogService;
import com.carrot_cake.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.carrot_cake.ecommerce.service.impl.ProductServiceImpl;
@Tag(
        name = "CRUD REST APIs for Accounts in KCBBank",
        description = "CRUD REST APIs in KCB Bank to CREATE, UPDATE, FETCH AND DELETE account details"
)
@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class ProductServiceImpl
{

    private ProductService productService;
    @Operation(
            summary = "Create Account REST API",
            description = "REST API to create new Customer &  Account inside KcbBank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody ProductDto productDto)
    {
        Object productServiceDto = new Object();
        productService.productCatalog(productServiceDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(ProductConstants.STATUS_201, CatalogConstants.MESSAGE_201));
    }
    @Operation(
            summary = "Fetch Account Details REST API",
            description = "REST API to fetch Customer &  Account details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/fetch")
    public ResponseEntity<ProductDto> fetchProductDetails(@RequestParam
                                                          @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                          String mobileNumber)
    {
        ProductDto productDto = ProductDto.fetchProduct(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }
    @Operation(summary = "Update Account Details REST API", description = "REST API to update Customer &  Account details based on a account number")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateProductDetails(@Valid @RequestBody CatalogDto catalogDto)
    {
        boolean isUpdated = CatalogService.updateProduct(catalogDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(ProductConstants.STATUS_200, CatalogConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(ProductConstants.STATUS_417, CatalogConstants.MESSAGE_417_UPDATE));
        }
    }
    @Operation(
            summary = "Delete Account & Customer Details REST API",
            description = "REST API to delete Customer &  Account details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteProductDetails(@RequestParam @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobileNumber) {
        @Pattern(regexp = "") String catalog = new String();
        boolean isDeleted = CatalogService.deleteCatalog(catalog);
        if(isDeleted)
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(CatalogConstants.STATUS_200, ProductConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(ProductConstants.STATUS_417, ProductConstants.MESSAGE_417_DELETE));
        }
    }


}
