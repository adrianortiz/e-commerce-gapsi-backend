package com.gapsi.ecommerce.exception;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = -284845136608143345L;

    public AppException() {
        super();
    }
    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
    public AppException(String message) {
        super(message);
    }
    public AppException(Throwable cause) {
        super(cause);
    }
}
