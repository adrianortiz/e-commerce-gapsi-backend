package com.gapsi.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ProveedorConflictException extends RuntimeException {

    private static final long serialVersionUID = 1341495158854509640L;

    public ProveedorConflictException() {
        super();
    }
    public ProveedorConflictException(String message, Throwable cause) {
        super(message, cause);
    }
    public ProveedorConflictException(String message) {
        super(message);
    }
    public ProveedorConflictException(Throwable cause) {
        super(cause);
    }
}
