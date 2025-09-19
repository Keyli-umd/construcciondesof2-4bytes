package app.api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DocumentoColValidator implements ConstraintValidator<DocumentoCol, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true; // usa @NotBlank aparte si es requerido
        return value.matches("\\d{8,10}");
    }
}
