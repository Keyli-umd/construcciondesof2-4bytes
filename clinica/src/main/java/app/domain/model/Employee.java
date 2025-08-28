package app.domain.model;

import java.time.LocalDate;
import app.domain.model.enums.Role;

public class Employee {
    private String fullName;
    private String idCard;  // must be unique
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private String address;
    private Role role;

    public Employee(String fullName, String idCard, String email, String phoneNumber,
                    LocalDate birthDate, String address, Role role) {
        this.fullName = fullName;
        this.idCard = idCard;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.role = role;
    }

    public String getFullName() { return fullName; }
    public String getIdCard() { return idCard; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getAddress() { return address; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", role=" + role +
                '}';
    }
}
