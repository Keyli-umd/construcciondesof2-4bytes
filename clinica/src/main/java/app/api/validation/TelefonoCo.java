package app.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TelefonoCoValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface TelefonoCo {
    String message() default "Teléfono inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
