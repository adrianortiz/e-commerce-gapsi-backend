package com.gapsi.ecommerce.exception;

import com.gapsi.ecommerce.exception.util.GapsiUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProveedorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(GapsiUtils.responseUtils(status, ex), headers, status);
    }

    @ExceptionHandler(value = AppException.class)
    protected ResponseEntity<Object> appException(AppException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(GapsiUtils.responseUtils(status, exception), status);
    }

    @ExceptionHandler(value = ProveedorNotFoundException.class)
    protected ResponseEntity<Object> proveeodorNotFoundException(ProveedorNotFoundException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(GapsiUtils.responseUtils(status, exception), status);
    }

    @ExceptionHandler(value = ProveedorConflictException.class)
    protected ResponseEntity<Object> proveedorConflictException(ProveedorConflictException exception) {
        HttpStatus status = HttpStatus.CONFLICT;
        return new ResponseEntity<>(GapsiUtils.responseUtils(status, exception), status);
    }
}
