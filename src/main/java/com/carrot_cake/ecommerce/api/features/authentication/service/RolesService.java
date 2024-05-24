package com.carrot_cake.ecommerce.api.features.authentication.service;

import com.carrot_cake.ecommerce.api.features.authentication.dto.RolesDto;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RolesService {
    Logger logger;

    /*
     * create, update, list one, soft delete
     * */
    public ResponseEntity<?> createRole(RolesDto roleDto) {
        try {

        } catch (Exception exception) {
            return new ResponseEntity<>("Could not create role", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
