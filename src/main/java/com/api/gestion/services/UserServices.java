package com.api.gestion.services;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserServices {

    ResponseEntity<String> singUp(Map<String, String>requesMap);
}
