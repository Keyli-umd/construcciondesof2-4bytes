package app.domain.model;

import java.time.LocalDate;
import app.domain.model.enums.Role;

public class HR extends User {

    public HR() {
        super();
        setRole(Role.HUMAN_RESOURCES);
    }

    public HR(String fullName, String idCard, String email, String phoneNumber,
              LocalDate birthDate, String address) {
        super(fullName, idCard, email, phoneNumber, birthDate, address, Role.HUMAN_RESOURCES);
    }

    @Override
    public String toString() {
        return "HR{" + super.toString() + "}";
    }
}
