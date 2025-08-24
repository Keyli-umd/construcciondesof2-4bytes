package app.domain.model;

import java.time.LocalDate;

public class MedicalInsurance {
    private String insurer;
    private String policyNumber;
    private boolean active;
    private LocalDate expirationDate;

    public MedicalInsurance() { }

    public MedicalInsurance(String insurer, String policyNumber, boolean active, LocalDate expirationDate) {
        this.insurer = insurer;
        this.policyNumber = policyNumber;
        this.active = active; 
        this.expirationDate = expirationDate;
    }

    public String getInsurer() { return insurer; }
    public void setInsurer(String insurer) { this.insurer = insurer; }

    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDate getexpirationDate() { return expirationDate; }
    public void setexpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate; }

    @Override
    public String toString() {
        return "MedicalInsurance{" +
                "insurer='" + insurer + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
