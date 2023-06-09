package com.gapsi.ecommerce.controller;

import com.gapsi.ecommerce.domain.FacturaDTO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
@RequestMapping("/factura")
public class FacturaController {

    @GetMapping("1")
    public Mono<FacturaDTO> buscarUno() {
        return Mono.just(new FacturaDTO(1, "Ordenador", 200));
    }

    @GetMapping
    public Flux<FacturaDTO> buscarTodos() {
        return Flux.just(new FacturaDTO(1, "Ordenador", 200), new FacturaDTO(2, "Telefono", 99));
    }

}
