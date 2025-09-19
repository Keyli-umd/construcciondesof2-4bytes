package app.domain.services;

import app.domain.ports.AdministrativeStaffPort;
import app.domain.ports.PatientPort;
import app.domain.ports.BillingPort;

import java.time.LocalDate;

public class AdministrativeStaffService implements AdministrativeStaffPort {

    private final PatientPort patientPort;
    private final BillingPort billingPort;

    public AdministrativeStaffService(PatientPort patientPort, BillingPort billingPort) {
        this.patientPort = patientPort;
        this.billingPort = billingPort;
    }

    @Override
    public String registerPatient(String username, String rawPassword, String idCard, String fullName, LocalDate birthDate,
                                  String gender, String address, String phone, String email) throws Exception {
        // Validar si el paciente ya existe
        try {
            String existingId = patientPort.findIdByIdCard(idCard);
            if (existingId != null) {
                throw new Exception("Patient with ID already exists: " + idCard);
            }
        } catch (Exception ignored) {
            // Si no existe, está bien
        }

        return idCard;
    }

    @Override
    public void scheduleAppointment(String patientIdCard, String doctorIdCard, LocalDate date) throws Exception {
        // Delegación a implementación concreta
        
    }

    @Override
    public void upsertEmergencyContact(String patientIdCard, String fullName, String relationship, String phone) throws Exception {
        // Delegación a implementación concreta (persistencia)
    }

    @Override
    public void upsertInsurance(String patientIdCard, String company, String policyNumber, boolean active, LocalDate expiration) throws Exception {
        // Delegación a implementación concreta (persistencia)
    }
}
