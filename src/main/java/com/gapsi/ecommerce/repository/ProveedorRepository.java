package com.gapsi.ecommerce.repository;

import com.gapsi.ecommerce.domain.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "proveedor", path = "proveedor")
public interface ProveedorRepository extends JpaRepository<Proveedor, String> {

    Proveedor findByNombre(@Param("nombre") String nombre);

}
