package app.domain.model;

import java.time.LocalDate;
import app.domain.model.enums.Role;

public class InformationSupport extends User {

    public InformationSupport() {
        super();
        setRole(Role.INFORMATION_SUPPORT);
    }

    public InformationSupport(String fullName, String idCard, String email, String phoneNumber,
                              LocalDate birthDate, String address) {
        super(fullName, idCard, email, phoneNumber, birthDate, address, Role.INFORMATION_SUPPORT);
    }

    @Override
    public String toString() {
        return "InformationSupport{" + super.toString() + "}";
    }
}
