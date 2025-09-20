package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class OrderItemInputValidator extends SimpleValidator {

    public String validateItemNumber(String value) throws Exception {
        return stringValidator("Número de ítem", value);
    }

    public String validateType(String value) throws Exception {
        return stringValidator("Tipo de ítem", value);
    }

    public String validateReferenceId(String value) throws Exception {
        return stringValidator("ID de referencia", value);
    }
}
