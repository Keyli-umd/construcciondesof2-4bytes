package app.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = HorarioAtencionValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface HorarioAtencion {
    String message() default "La fecha/hora está fuera del horario de atención (L–V 08:00–18:00)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
