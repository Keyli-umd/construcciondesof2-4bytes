package app.domain.ports;

import java.time.LocalDate;

public interface AdministrativeStaffPort {
    String registerPatient(String username, String rawPassword, String idCard, String fullName, LocalDate birthDate,
            String gender, String address, String phone, String email) throws Exception;

    void scheduleAppointment(String patientIdCard, String doctorIdCard, LocalDate date) throws Exception;

    void upsertEmergencyContact(String patientIdCard, String fullName, String relationship, String phone)
            throws Exception;

    void upsertInsurance(String patientIdCard, String company, String policyNumber, boolean active,
            LocalDate expiration) throws Exception;
}