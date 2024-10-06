package com.api.gestion.services.impl;

import com.api.gestion.constants.FacturaConstantes;
import com.api.gestion.dao.UserDAO;
import com.api.gestion.pojo.User;
import com.api.gestion.services.UserServices;
import com.api.gestion.util.FacturasUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserDAO userDAO;
    @Override
    public ResponseEntity<String> singUp(Map<String, String> requesMap) {
       log.info("Registro interno de un usuario {}" , requesMap);
       try{
           if (validateSingUpMap(requesMap)){
               User user = userDAO.findByEmail(requesMap.get("email"));
               if (Objects.isNull(user)){
                    userDAO.save(getUserFromMap(requesMap));
                    return FacturasUtils.getResponseEntity("Usuario registrado con exito",HttpStatus.CREATED);
               }else {
                   return FacturasUtils.getResponseEntity("El usuario con ese email ya existe", HttpStatus.BAD_REQUEST);
               }
           }else {
               return FacturasUtils.getResponseEntity(FacturaConstantes.INVALID_DATA,HttpStatus.BAD_REQUEST);
           }
       }catch (Exception exception){
           exception.printStackTrace();
       }
       return FacturasUtils.getResponseEntity(FacturaConstantes.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validateSingUpMap(Map<String, String> requesMap){
        if (requesMap.containsKey("nombre") && requesMap.containsKey("numeroDeContacto") && requesMap.containsKey("email")&& requesMap.containsKey("password")){
            return true;
        }
        return false;
    }

    private User getUserFromMap(Map<String, String> requesMap){
        User user = new User();
        user.setNombre(requesMap.get("nombre"));
        user.setNumeroDeContacto(requesMap.get("numeroDeContacto"));
        user.setEmail(requesMap.get("email"));
        user.setPassword(requesMap.get("password"));
        user.setStatus("false");
        user.setRol("user");
        return user;
    }
}
