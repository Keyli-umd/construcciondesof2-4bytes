package app.domain.model;

import java.time.LocalDate;
import app.domain.model.enums.Role;

public class Nurse extends User {

    public Nurse() {
        super();
        setRole(Role.NURSES);
    }

    public Nurse(String fullName, String idCard, String email, String phoneNumber,
                 LocalDate birthDate, String address) {
        super(fullName, idCard, email, phoneNumber, birthDate, address, Role.NURSES);
    }

    @Override
    public String toString() {
        return "Nurse{" + super.toString() + "}";
    }
}
