package app.domain.model;

import java.time.LocalDate;
import app.domain.model.enums.Role;

public class Doctor extends User {

    public Doctor() {
        super();
        setRole(Role.DOCTORS);
    }

    public Doctor(String fullName, String idCard, String email, String phoneNumber,
                  LocalDate birthDate, String address) {
        super(fullName, idCard, email, phoneNumber, birthDate, address, Role.DOCTORS);
    }

    @Override
    public String toString() {
        return "Doctor{" + super.toString() + "}";
    }
}
