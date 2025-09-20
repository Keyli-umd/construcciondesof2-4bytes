package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class DiagnosticAidOrderItemInputValidator extends SimpleValidator {

    public String validateId(String value) throws Exception {
        return stringValidator("ID del ítem de ayuda diagnóstica", value);
    }

    public String validateItemNumber(String value) throws Exception {
        return stringValidator("Número de ítem", value);
    }

    public String validateName(String value) throws Exception {
        return stringValidator("Nombre del ítem", value);
    }

    public boolean validateResultAvailable(String value) throws Exception {
        return booleanValidator("Disponibilidad del resultado", value);
    }
}
