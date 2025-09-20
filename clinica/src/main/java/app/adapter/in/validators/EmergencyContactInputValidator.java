package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class EmergencyContactInputValidator extends SimpleValidator {

    public String validateFirstName(String value) throws Exception {
        return stringValidator("Nombre del contacto", value);
    }

    public String validateLastName(String value) throws Exception {
        return stringValidator("Apellido del contacto", value);
    }

    public String validateRelationship(String value) throws Exception {
        return stringValidator("Relación con el paciente", value);
    }

    public String validatePhone(String value) throws Exception {
        if (value == null || !value.matches("\\d{10}")) {
            throw new Exception("El número de teléfono debe tener exactamente 10 dígitos");
        }
        return value;
    }

    public String validatePatientDocument(String value) throws Exception {
        return stringValidator("Documento del paciente", value);
    }
}
