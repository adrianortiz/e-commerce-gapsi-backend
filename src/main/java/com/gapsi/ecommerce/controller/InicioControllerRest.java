package com.gapsi.ecommerce.controller;

import com.gapsi.ecommerce.component.AppProperties;
import com.gapsi.ecommerce.data.ProveedorData;
import com.gapsi.ecommerce.response.InicioResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
@RequestMapping("/inicio")
public class InicioControllerRest {

    Logger log = LoggerFactory.getLogger(InicioControllerRest.class);

    @Autowired
    private AppProperties appProperties;

    // @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public ResponseEntity<Object> info() {
        log.info("Inicio - info");

        InicioResponse response = new InicioResponse(200, appProperties.getWelcome(), appProperties.getVersion(), new Date());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/template")
    public List<ProveedorData> buscarTodas() {

        // Example to connect to other micro webservice using template
        RestTemplate plantilla = new RestTemplate();
        ProveedorData[] miArray = plantilla.getForObject("http://localhost:8081/rest/proveedor", ProveedorData[].class);
        return Arrays.asList(miArray);
    }
}
