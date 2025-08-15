package app.domain.model.employee;
import app.domain.model.valueobjects.Address;
import app.domain.model.valueobjects.EmailAddress;
import app.domain.model.valueobjects.FullName;

import app.domain.model.valueobjects.NationalId;
import app.domain.model.valueobjects.PhoneNumber;

public abstract class Employee {
    protected NationalId nationalId;
    protected FullName fullName;
    protected EmailAddress email;
    protected PhoneNumber phone;
    protected Address address;
    // protected Role role;

    public Employee(NationalId nationalId, FullName fullName, EmailAddress email, PhoneNumber phone, Address address) {
        this.nationalId = nationalId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        // this.role = role;
    }

    public NationalId getNationalId() { return nationalId; }
    public FullName getFullName() { return fullName; }
    public EmailAddress getEmail() { return email; }
    public PhoneNumber getPhone() { return phone; }
    public Address getAddress() { return address; }
    // public Role getRole() { return role; }
}
