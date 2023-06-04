package com.gapsi.ecommerce.controller;

import com.gapsi.ecommerce.component.AppProperties;
import com.gapsi.ecommerce.response.InicioResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/inicio")
public class InicioControllerRest {

    Logger log = LoggerFactory.getLogger(InicioControllerRest.class);

    @Autowired
    private AppProperties appProperties;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public ResponseEntity<Object> info() {
        log.info("Inicio - info");

        InicioResponse response = new InicioResponse(200, appProperties.getWelcome(), appProperties.getVersion(), new Date());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
