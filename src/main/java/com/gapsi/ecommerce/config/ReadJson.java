package com.gapsi.ecommerce.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gapsi.ecommerce.component.AppProperties;
import com.gapsi.ecommerce.data.ProveedorData;
import com.gapsi.ecommerce.domain.Proveedor;
import com.gapsi.ecommerce.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ReadJson implements CommandLineRunner {

    @Autowired
    AppProperties appProperties;

    @Autowired
    private IService<Proveedor> proveedorIService;

    @Override
    public void run(String... args) throws Exception {

        if (proveedorIService.getTotalRows() == 0) {

            try {
                TypeReference<List<ProveedorData>> typeReference = new TypeReference<List<ProveedorData>>() {};
                InputStream inputStream = TypeReference.class.getResourceAsStream("/bd/bd.json");

                List<ProveedorData> proveedores = new ObjectMapper().readValue(inputStream, typeReference);

                if (proveedores != null && !proveedores.isEmpty()) {
                    List<Proveedor> proveedorList = new ArrayList<>();
                    proveedores.forEach(proveedor -> proveedorList.add(new Proveedor(proveedor.getNombre().toLowerCase(), proveedor.getRazon(), proveedor.getDireccion())));
                    proveedorList.forEach(System.out::println);
                    List<Proveedor> savedBookList = proveedorIService.saveAll(proveedorList);
                    System.out.println("Total registros en JSON: " + savedBookList.size());
                }

            } catch (Exception ex) {
                System.out.println("Error al leer Json - " + ex.getMessage());

            }
        }
    }
}
