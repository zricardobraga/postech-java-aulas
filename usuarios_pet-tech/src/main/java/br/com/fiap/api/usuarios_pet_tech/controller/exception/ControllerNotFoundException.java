package br.com.fiap.api.usuarios_pet_tech.controller.exception;

public class ControllerNotFoundException extends RuntimeException{

    public ControllerNotFoundException(String message) {
        super(message);
    }
}
