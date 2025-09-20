package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class MedicationOrderItemInputValidator extends SimpleValidator {

    public String validateId(String value) throws Exception {
        return stringValidator("ID del ítem de medicamento", value);
    }

    public String validateDose(String value) throws Exception {
        return stringValidator("Dosis del medicamento", value);
    }

    public int validateDurationDays(String value) throws Exception {
        int days = intValidator("Duración del tratamiento (días)", value);
        if (days <= 0) {
            throw new Exception("La duración del tratamiento debe ser mayor a cero");
        }
        return days;
    }

    public String validateItemNumber(String value) throws Exception {
        return stringValidator("Número de ítem", value);
    }
}
