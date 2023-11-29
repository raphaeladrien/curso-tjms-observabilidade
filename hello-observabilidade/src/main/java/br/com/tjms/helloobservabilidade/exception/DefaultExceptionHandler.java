package br.com.tjms.helloobservabilidade.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {

    private static final Logger logger = LoggerFactory
        .getLogger(DefaultExceptionHandler.class);
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RestError> handleRuntimeException(RuntimeException ex){
        logger.error(ex.getMessage(), ex);
        return ResponseEntity.unprocessableEntity().body(new RestError(
            "00001", "Não é possível processar o seu pedido")
        );
    }
    protected record RestError(String code, String message) {}
}
