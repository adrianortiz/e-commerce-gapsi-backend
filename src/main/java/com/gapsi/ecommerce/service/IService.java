package com.gapsi.ecommerce.service;

import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface IService<T> {

    Iterable<T> findAll();
    Iterable<T> findAll(PageRequest nombre);
    Optional<T> findById(String nombre);
    T saveOrUpdate(T t);
    List<T> saveAll(List<T> t);
    Boolean deleteById(String nombre);
    void updatedDataJson();
    int getTotalRows();

}
