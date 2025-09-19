package app.api.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;

import jakarta.validation.ConstraintViolationException; // ✅ Import correcto

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "Validación fallida");
        List<Map<String, String>> errors = new ArrayList<>();

        for (FieldError fe : ex.getBindingResult().getFieldErrors()) {
            Map<String, String> e = new HashMap<>();
            e.put("field", fe.getField());
            e.put("error", fe.getDefaultMessage());
            errors.add(e);
        }
        body.put("errors", errors);
        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(ConstraintViolationException.class) // ✅ usa jakarta
    public ResponseEntity<Map<String, Object>> handleConstraintViolation(ConstraintViolationException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "Parámetros inválidos");
        List<Map<String, String>> errors = new ArrayList<>();

        ex.getConstraintViolations().forEach(v -> {
            Map<String, String> e = new HashMap<>();
            e.put("property", String.valueOf(v.getPropertyPath()));
            e.put("error", v.getMessage());
            errors.add(e);
        });

        body.put("errors", errors);
        return ResponseEntity.badRequest().body(body);
    }
}
