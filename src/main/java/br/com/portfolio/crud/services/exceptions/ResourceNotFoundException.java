package br.com.portfolio.crud.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Usuário não localizado com esta id " + id);
    }
}