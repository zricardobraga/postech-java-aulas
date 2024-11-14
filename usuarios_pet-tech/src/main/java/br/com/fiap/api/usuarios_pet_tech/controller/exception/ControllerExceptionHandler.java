package br.com.fiap.api.usuarios_pet_tech.controller.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

//informa o spring que o erro será captado na camada de controller
@ControllerAdvice
public class ControllerExceptionHandler {
    //classe que captura o erro na camada de controller

    private StandardError err = new StandardError();

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ControllerNotFoundException e,
                                                        HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;

        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Entity not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());


        return ResponseEntity.status(status).body(this.err);
    }

    //Erro de validação
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e,
                                                        HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidateError validateError = new ValidateError();

        validateError .setTimestamp(Instant.now());
        validateError .setStatus(status.value());
        validateError .setError("Erro de validação");
        validateError .setMessage(e.getMessage());
        validateError .setPath(request.getRequestURI());

        for (FieldError f: e.getBindingResult().getFieldErrors()){
            validateError.addMensagens(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(validateError);
    }
}
