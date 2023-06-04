package com.gapsi.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProveedorNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1888391864803547338L;

    public ProveedorNotFoundException() {
        super();
    }
    public ProveedorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public ProveedorNotFoundException(String message) {
        super(message);
    }
    public ProveedorNotFoundException(Throwable cause) {
        super(cause);
    }
}
