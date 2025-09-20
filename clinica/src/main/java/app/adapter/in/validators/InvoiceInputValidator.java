package app.adapter.in.validators;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class InvoiceInputValidator extends SimpleValidator {

    public long validatePatientId(String value) throws Exception {
        return longValidator("ID del paciente", value);
    }

    public String validatePolicyNumber(String value) throws Exception {
        return stringValidator("Número de póliza", value);
    }

    public double validateAmount(String value) throws Exception {
        return doubleValidator("Monto de la factura", value);
    }

    public String validateDescription(String value) throws Exception {
        return stringValidator("Descripción de la factura", value);
    }

    public LocalDateTime validateDateTime(String value) throws Exception {
        try {
            return LocalDateTime.parse(value);
        } catch (Exception e) {
            throw new Exception("Formato inválido de fecha (yyyy-MM-ddTHH:mm)");
        }
    }
}
