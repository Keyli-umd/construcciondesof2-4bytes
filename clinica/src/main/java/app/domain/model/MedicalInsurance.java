package app.domain.model;

import java.time.LocalDate;

public class MedicalInsurance {
    private String companyName;
    private String policyNumber;
    private boolean active;
    private LocalDate expirationDate;

    public MedicalInsurance(String companyName, String policyNumber, boolean active, LocalDate expirationDate) {
        this.companyName = companyName;
        this.policyNumber = policyNumber;
        this.active = active;
        this.expirationDate = expirationDate;
    }

    public boolean isValid() {
        return active && expirationDate.isAfter(LocalDate.now());
    }

    public String getCompanyName() { return companyName; }
    public String getPolicyNumber() { return policyNumber; }
    public boolean isActive() { return active; }
    public LocalDate getExpirationDate() { return expirationDate; }
}
