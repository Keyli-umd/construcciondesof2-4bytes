package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class InventoryItemInputValidator extends SimpleValidator {

    public String validateId(String value) throws Exception {
        return stringValidator("ID del ítem de inventario", value);
    }

    public String validateName(String value) throws Exception {
        return stringValidator("Nombre del ítem", value);
    }

    public String validateType(String value) throws Exception {
        return stringValidator("Tipo del ítem", value);
    }
}
