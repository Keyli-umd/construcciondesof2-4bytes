package app.domain.model;

import java.time.LocalDate;
import app.domain.model.enums.Role;

public class AdministrativeStaff extends User {

    public AdministrativeStaff() {
        super();
        setRole(Role.ADMINISTRATIVE_STAFF);
    }

    public AdministrativeStaff(String fullName, String idCard, String email, String phoneNumber,
                               LocalDate birthDate, String address) {
        super(fullName, idCard, email, phoneNumber, birthDate, address, Role.ADMINISTRATIVE_STAFF);
    }

    @Override
    public String toString() {
        return "AdministrativeStaff{" + super.toString() + "}";
    }
}
