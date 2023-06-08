package com.gapsi.ecommerce.service.impl;

import com.gapsi.ecommerce.component.AppProperties;
import com.gapsi.ecommerce.domain.Proveedor;
import com.gapsi.ecommerce.repository.ProveedorRepository;
import com.gapsi.ecommerce.service.IService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProveedorServiceImpl implements IService<Proveedor> {

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public Iterable<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public Iterable<Proveedor> findAll(PageRequest nombre) {
        return proveedorRepository.findAll(nombre);
    }

    @Override
    public Optional<Proveedor> findById(String nombre) {
        return proveedorRepository.findById(nombre);
    }

    @Override
    public Proveedor saveOrUpdate(Proveedor proveedor) {
        Proveedor proveedor1 = proveedorRepository.saveAndFlush(proveedor);
        this.updatedDataJson();
        return proveedor1;
    }

    @Override
    public List<Proveedor> saveAll(List<Proveedor> t) {
        return proveedorRepository.saveAll(t);
    }

    @Override
    public Boolean deleteById(String nombre) {
        try {
            proveedorRepository.deleteById(nombre);
            this.updatedDataJson();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void updatedDataJson() {

        List<Proveedor> iterable = proveedorRepository.findAll();

        if (iterable.size() > 0) {
            JSONArray proveedorlist = new JSONArray();
            for (Proveedor proveedor : iterable) {
                JSONObject proveedorJson = new JSONObject();
                proveedorJson.put("direccion", proveedor.getDireccion());
                proveedorJson.put("nombre", proveedor.getNombre());
                proveedorJson.put("razon", proveedor.getRazon());
                proveedorlist.add(proveedorJson);
            }

            try (FileWriter file = new FileWriter(appProperties.getJson())) {
                file.write(proveedorlist.toJSONString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public int getTotalRows() {
        return proveedorRepository.getTotalRows();
    }
}
