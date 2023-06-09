package com.gapsi.ecommerce.domain;

public class FacturaDTO {

    private int numero;
    private String nombre;
    private double monto;

    public FacturaDTO() {
    }

    public FacturaDTO(int numero, String nombre, double monto) {
        this.numero = numero;
        this.nombre = nombre;
        this.monto = monto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "FacturaDTO{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", monto=" + monto +
                '}';
    }
}
