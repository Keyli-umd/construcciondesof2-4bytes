package app.adapter.in.validators;

public class SimpleValidator {

    public String stringValidator(String label, String value) throws Exception {
        if (value == null || value.trim().isEmpty()) {
            throw new Exception("El campo '" + label + "' no puede estar vacío");
        }
        return value.trim();
    }

    public long longValidator(String label, String value) throws Exception {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new Exception("El campo '" + label + "' debe ser un número entero largo");
        }
    }

    public int intValidator(String label, String value) throws Exception {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new Exception("El campo '" + label + "' debe ser un número entero");
        }
    }

    public double doubleValidator(String label, String value) throws Exception {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new Exception("El campo '" + label + "' debe ser un número decimal");
        }
    }

    public boolean booleanValidator(String label, String value) throws Exception {
        if (value == null) {
            throw new Exception("El campo '" + label + "' no puede estar vacío");
        }
        if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(value);
        }
        throw new Exception("El campo '" + label + "' debe ser 'true' o 'false'");
    }
}
