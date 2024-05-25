package com.carrot_cake.ecommerce.controllers;

import com.carrot_cake.ecommerce.dto.CatalogDto;
import com.carrot_cake.ecommerce.dto.ErrorResponseDto;
import com.carrot_cake.ecommerce.service.CatalogService;
import com.carrot_cake.ecommerce.constants.CatalogConstants;
import com.carrot_cake.ecommerce.constants.ProductConstants;
import com.carrot_cake.ecommerce.constants.CatalogConstants;
import com.carrot_cake.ecommerce.dto.ResponseDto;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Tag
        (
        name = "CRUD REST APIs for Accounts in KCBBank",
        description = "CRUD REST APIs in KCB Bank to CREATE, UPDATE, FETCH AND DELETE account details"
)
@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class CatalogController
{

    private CatalogService CatalogService;
    @Operation(
            summary = "Create Account REST API",
            description = "REST API to create new Product & Catalog inside KcbBank"
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
    public ResponseEntity<ResponseDto> createCatalog(@Valid @RequestBody CatalogDto catalogDto)
    {
        CatalogService.createCatalog(catalogDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CatalogConstants.STATUS_201, CatalogConstants.MESSAGE_201));
    }
    @Operation(
            summary = "Fetch Account Details REST API",
            description = "REST API to fetch Product & Catalog details based on a mobile number"
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
    public ResponseEntity<CatalogDto> fetchCatalogDetails(@RequestParam
                                                           @Pattern(regexp="(^$|[0-9]{10})",message = "Catalog")
                                                           String mobileNumber)
    {
        CatalogDto catalogDto = CatalogService.fetchCatalog(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(catalogDto);
    }
    @Operation(summary = "Update Catalog Details REST API",
               description = "REST API to update Product & Catalog details based on account number")
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
    public ResponseEntity<ResponseDto> updateCatalogDetails(@Valid @RequestBody CatalogDto catalogDto)
    {
        boolean isUpdated = com.carrot_cake.ecommerce.service.CatalogService.updateCatalog(catalogDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(CatalogConstants.STATUS_200, CatalogConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(CatalogConstants.STATUS_417, CatalogConstants.MESSAGE_417_UPDATE));
        }
    }
    @Operation(
            summary = "Delete Account & Customer Details REST API",
            description = "REST API to delete Product &  Catalog details Based on a Mobile Number"
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
    public ResponseEntity<ResponseDto> deleteCatalogDetails(@RequestParam @Pattern(regexp="(^$|[0-9]{10})",message = "Deleted Catalog") String catalog)
    {
        boolean isDeleted = com.carrot_cake.ecommerce.service.CatalogService.deleteCatalog(catalog);
        if(isDeleted)
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(CatalogConstants.STATUS_200, CatalogConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(CatalogConstants.STATUS_417, CatalogConstants.MESSAGE_417_DELETE));
        }
    }


}
