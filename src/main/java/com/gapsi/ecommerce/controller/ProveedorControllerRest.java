package com.gapsi.ecommerce.controller;

import com.gapsi.ecommerce.domain.Proveedor;
import com.gapsi.ecommerce.exception.AppException;
import com.gapsi.ecommerce.exception.ProveedorConflictException;
import com.gapsi.ecommerce.exception.ProveedorNotFoundException;
import com.gapsi.ecommerce.response.ProveedorPaggingResponse;
import com.gapsi.ecommerce.response.ProveedorResponse;
import com.gapsi.ecommerce.service.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/proveedor")
public class ProveedorControllerRest {

    Logger log = LoggerFactory.getLogger(ProveedorControllerRest.class);

    @Autowired
    private IService<Proveedor> proveedorIService;

    @GetMapping
    public ResponseEntity<Collection<Proveedor>> findAll() {
        log.info("Proveedor - Consultar todos");
        Iterable<Proveedor> proveedores = proveedorIService.findAll();
        List<Proveedor> response = new ArrayList<>();
        // proveedores.forEach(response::add);
        proveedores.forEach(book -> {
            book.add(linkTo(methodOn(ProveedorControllerRest.class).findById(book.getNombre())).withSelfRel());
            response.add(book);
        });
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/paginado")
    public ResponseEntity<ProveedorPaggingResponse> findAllPaging(
            @RequestParam(name = "pagina", defaultValue = "0") int pagina,
            @RequestParam(name = "size", defaultValue = "8") int size
    ) {

        log.info("Proveedor - Consultar todos con Paging");

        Iterable<Proveedor> proveedores = proveedorIService.findAll(PageRequest.of(pagina, size));
        List<Proveedor> response = new ArrayList<>();
        // proveedores.forEach(response::add);
        proveedores.forEach(book -> {
            book.add(linkTo(methodOn(ProveedorControllerRest.class).findById(book.getNombre())).withSelfRel());
            response.add(book);
        });

        ProveedorPaggingResponse paginado = new ProveedorPaggingResponse();
        paginado.setPagina(pagina);
        paginado.setSize(size);
        paginado.setTotal(proveedorIService.getTotalRows());
        paginado.setProveedores(response);

        return new ResponseEntity<>(paginado, HttpStatus.OK);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Object> findById(@PathVariable String nombre) {
        log.info("Proveedor - Buscar por id nombre");

        Proveedor proveedor = null;
        Optional<Proveedor> optional = proveedorIService.findById(nombre.toLowerCase());

        if (!optional.isPresent()) {
            throw new ProveedorNotFoundException("Proveedor con nombre = '" + nombre + "' no existe.");
        } else {
            proveedor = optional.get();
            proveedor.add(linkTo(methodOn(ProveedorControllerRest.class).findAll()).withSelfRel());
        }
        return new ResponseEntity<>(proveedor, HttpStatus.OK);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> save(@RequestBody @Valid Proveedor proveedor) {
        log.info("Proveedor - Guardar");

        Optional<Proveedor> optional = proveedorIService.findById(proveedor.getNombre().toLowerCase());
        if (optional.isPresent()) {
            throw new ProveedorConflictException("Proveedor con nombre = '" + proveedor.getNombre() + "' ya existe.");
        } else {
            proveedor.setNombre(proveedor.getNombre().toLowerCase());
            Proveedor nuevoProveedor = proveedorIService.saveOrUpdate(proveedor);
            nuevoProveedor.add(linkTo(methodOn(ProveedorControllerRest.class).findById(nuevoProveedor.getNombre())).withSelfRel());
            nuevoProveedor.add(linkTo(methodOn(ProveedorControllerRest.class).findAll()).withSelfRel());
            return new ResponseEntity<>(nuevoProveedor, HttpStatus.CREATED);
        }

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@RequestBody @Valid Proveedor proveedor) {
        log.info("Proveedor - Actualizar");

        Optional<Proveedor> optional = proveedorIService.findById(proveedor.getNombre().toLowerCase());
        if (!optional.isPresent()) {
            throw new ProveedorNotFoundException("Proveedor con nombre = '" + proveedor.getNombre() + "' No existe.");
        } else {
            proveedor.setNombre(proveedor.getNombre().toLowerCase());
            Proveedor nuevoProveedor = proveedorIService.saveOrUpdate(proveedor);
            nuevoProveedor.add(linkTo(methodOn(ProveedorControllerRest.class).findById(nuevoProveedor.getNombre())).withSelfRel());
            nuevoProveedor.add(linkTo(methodOn(ProveedorControllerRest.class).findAll()).withSelfRel());
            return new ResponseEntity<>(nuevoProveedor, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("{nombre}")
    public ResponseEntity<Object> deleteById(@PathVariable String nombre) {
        log.info("Proveedor - Eliminar por Id Nombre");
        Optional<Proveedor> proveedor = proveedorIService.findById(nombre);
        if (!proveedor.isPresent()) {
            throw new ProveedorNotFoundException("Proveedor con nombre = '" + nombre + "' No existe.");
        } else {

            if (proveedorIService.deleteById(nombre) ) {
                // status 204
                return ResponseEntity.status(HttpStatus.OK).body(new ProveedorResponse(200, "Proveedor eliminado, no hay contenido", new Date()));
            } else {
                throw new AppException("Error al eliminar Proveedor");
            }
        }
    }

}
