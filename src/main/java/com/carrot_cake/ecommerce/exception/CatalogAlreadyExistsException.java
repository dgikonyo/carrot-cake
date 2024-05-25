package com.carrot_cake.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CatalogAlreadyExistsException extends RuntimeException
{

    public CatalogAlreadyExistsException(String message)
    {
        super(message);
    }

}
