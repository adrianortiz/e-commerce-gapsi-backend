package com.gapsi.ecommerce.response;

import com.gapsi.ecommerce.domain.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class ProveedorPaggingResponse {

    private int pagina;
    private int size;
    private List<Proveedor> proveedores = new ArrayList<>();

    public ProveedorPaggingResponse() {};

    public ProveedorPaggingResponse(int pagina, int size, List<Proveedor> proveedores) {
        this.pagina = pagina;
        this.size = size;
        this.proveedores = proveedores;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    @Override
    public String toString() {
        return "ProveedorPaggingResponse{" +
                "pagina=" + pagina +
                ", size=" + size +
                ", proveedores=" + proveedores +
                '}';
    }
}
