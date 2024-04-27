package br.com.portfolio.crud.resource.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.portfolio.crud.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String erro = "Não foi possível encontrar a informação solicitada.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError errorDefault = new StandardError(Instant.now(), status.value(), erro, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(errorDefault);
    }
}
