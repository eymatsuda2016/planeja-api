package io.github.com.eymatsuda2016.planeja.infra.handlers;

import io.github.com.eymatsuda2016.planeja.common.exceptions.ValidationException;
import io.github.com.eymatsuda2016.planeja.common.validation.CampoInvalido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleValidationException(ValidationException e) {
        var status = HttpStatus.UNPROCESSABLE_CONTENT;
        var body = Map.of("timestamp", LocalDateTime.now(),
                "status", status.value(),
                "erro", e.getMessage(),
                "camposInvalidos", e.getCamposInvalido()
        );

        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        var camposInvalidos = e.getFieldErrors()
                .stream()
                .map(fe -> new CampoInvalido(fe.getField(), fe.getDefaultMessage()))
                .toList();

        var status = HttpStatus.UNPROCESSABLE_CONTENT;
        var body = Map.of("timestamp", LocalDateTime.now(),
                "status", status.value(),
                "erro", e.getMessage(),
                "camposInvalidos", camposInvalidos
        );
        return ResponseEntity.status(status).body(body);
    }
}
