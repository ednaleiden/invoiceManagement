package com.api.gestion.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FacturasUtils {

    private FacturasUtils(){

    }

    public static ResponseEntity<String> getResponseEntity(String message, HttpStatus httpStatus){
        return new ResponseEntity<String>("Mensaje :" + message, httpStatus);
    }
}
