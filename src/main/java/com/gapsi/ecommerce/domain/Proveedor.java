package com.gapsi.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Proveedor extends RepresentationModel<Proveedor> {

    @Id
    @Column(nullable = false, length = 250, unique = true)
    @NotBlank(message = "El Nombre del Proveedor no puede estar en blanco")
    @Length(min = 1, max = 250, message = "El Nombre del Proveedor debe tener entre 1 y 250 caracteres")
    private String nombre;

    @Column(nullable = false, length = 250, unique = false)
    @NotBlank(message = "La Razón social del Proveedor no puede estar en blanco")
    @Length(min = 1, max = 250, message = "La Razón social del Proveedor debe tener entre 1 y 250 caracteres")
    private String razon;

    @Column(nullable = false, length = 250, unique = false)
    @NotBlank(message = "La Dirección del Proveedor no puede estar en blanco")
    @Length(min = 1, max = 250, message = "La Dirección del Proveedor debe tener entre 1 y 250 caracteres")
    private String direccion;

    public Proveedor() {

    }

    @JsonCreator
    public Proveedor(@JsonProperty("nombre") String nombre, @JsonProperty("razon") String razon, @JsonProperty("direccion") String direccion) {
        this.nombre = nombre;
        this.razon = razon;
        this.direccion = direccion;
    }

    public Proveedor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "nombre='" + nombre + '\'' +
                ", razon='" + razon + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor proveedor = (Proveedor) o;
        return Objects.equals(nombre, proveedor.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
