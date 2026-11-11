package com.igor.Nfes_integration_lab.exception;

import com.igor.Nfes_integration_lab.exception.message.ErrorMessage;
import com.igor.Nfes_integration_lab.exception.message.FieldErrorResponse;
import com.igor.Nfes_integration_lab.exception.message.ValidationErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorMessage> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpServletRequest request){

        List<FieldErrorResponse> details = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> new FieldErrorResponse(e.getField(), e.getDefaultMessage()))
                .toList();

        ValidationErrorMessage errorMessage = new ValidationErrorMessage(
                Instant.now(),
                400,
                "BAD_REQUEST",
                "Campos inválidos",
                request.getRequestURI(),
                details
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
