package app.api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.*;

public class HorarioAtencionValidator implements ConstraintValidator<HorarioAtencion, LocalDateTime> {

    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
        if (value == null) return true;
        DayOfWeek d = value.getDayOfWeek();
        if (d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY) return false;
        LocalTime t = value.toLocalTime();
        return !t.isBefore(LocalTime.of(8,0)) && !t.isAfter(LocalTime.of(18,0));
    }
}
