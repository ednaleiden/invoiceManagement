package com.api.gestion.rest;

import com.api.gestion.constants.FacturaConstantes;
import com.api.gestion.services.UserServices;
import com.api.gestion.util.FacturasUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/singup")
    public ResponseEntity<String> registrarUsuario(@RequestBody(required = true)Map<String,String> requestMap){
        try{
           return userServices.singUp(requestMap);

        } catch (Exception exception){
            exception.printStackTrace();
        }
        return FacturasUtils.getResponseEntity(FacturaConstantes.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
