package app.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import app.domain.model.enums.Role;

public class Patient extends User {

    private String healthInsuranceProvider;
    private EmergencyContact emergencyContact;
    private MedicalInsurance medicalInsurance;
    private List<MedicalHistory> medicalHistories;

    public Patient() {
        super();
        setRole(Role.PATIENTS);
        this.medicalHistories = new ArrayList<>();
    }

    public Patient(String fullName, String idNumber, String email, String phone,
                   LocalDate birthDate, String address, String healthInsuranceProvider,
                   EmergencyContact emergencyContact, MedicalInsurance medicalInsurance) {
        super(fullName, idNumber, email, phone, birthDate, address, Role.PATIENTS);
        this.healthInsuranceProvider = healthInsuranceProvider;
        this.emergencyContact = emergencyContact;
        this.medicalInsurance = medicalInsurance;
        this.medicalHistories = new ArrayList<>();
    }

    public String getHealthInsuranceProvider() { return healthInsuranceProvider; }
    public void setHealthInsuranceProvider(String healthInsuranceProvider) { this.healthInsuranceProvider = healthInsuranceProvider; }

    public EmergencyContact getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(EmergencyContact emergencyContact) { this.emergencyContact = emergencyContact; }

    public MedicalInsurance getMedicalInsurance() { return medicalInsurance; }
    public void setMedicalInsurance(MedicalInsurance medicalInsurance) { this.medicalInsurance = medicalInsurance; }

    public List<MedicalHistory> getMedicalHistories() { return medicalHistories; }
    public void addMedicalHistory(MedicalHistory history) { this.medicalHistories.add(history); }

    @Override
    public String toString() {
        return "Patient{" +
                super.toString() +
                ", healthInsuranceProvider='" + healthInsuranceProvider + '\'' +
                ", emergencyContact=" + emergencyContact +
                ", medicalInsurance=" + medicalInsurance +
                ", medicalHistories=" + medicalHistories +
                '}';
    }
}
