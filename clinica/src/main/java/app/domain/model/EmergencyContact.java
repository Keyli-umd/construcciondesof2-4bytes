package app.domain.model;

public class EmergencyContact {
    private String fullName;
    private String relation;
    private String phoneNumber;

    public EmergencyContact(String fullName, String relation, String phoneNumber) {
        validatePhoneNumber(phoneNumber);

        this.fullName = fullName;
        this.relation = relation;
        this.phoneNumber = phoneNumber;
    }

    private void validatePhoneNumber(String phone) {
        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("El numero de emergencia debe tener 10 digitos ");
        }
    }

    public String getFullName() { return fullName; }
    public String getRelation() { return relation; }
    public String getPhoneNumber() { return phoneNumber; }
}
