package app.adapter.out.memory;

import app.domain.ports.AdministrativeStaffPort;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class InMemoryAdministrativeStaffPort implements AdministrativeStaffPort {

    private final Map<String, PatientRecord> patients = new HashMap<>();
    private final Map<String, AppointmentRecord> appointments = new HashMap<>();

    @Override
    public String registerPatient(String username, String rawPassword, String idCard, String fullName,
                                  LocalDate birthDate, String gender, String address, String phone, String email) throws Exception {
        if (patients.containsKey(idCard)) {
            throw new Exception("Patient already exists with ID: " + idCard);
        }
        patients.put(idCard, new PatientRecord(username, fullName, birthDate, gender, address, phone, email));
        return idCard;
    }

    @Override
    public void scheduleAppointment(String patientIdCard, String doctorIdCard, LocalDate date) throws Exception {
        String appointmentId = patientIdCard + "-" + doctorIdCard + "-" + date;
        appointments.put(appointmentId, new AppointmentRecord(patientIdCard, doctorIdCard, date));
    }

    @Override
    public void upsertEmergencyContact(String patientIdCard, String fullName, String relationship, String phone) throws Exception {
        PatientRecord record = patients.get(patientIdCard);
        if (record == null) throw new Exception("Patient not found: " + patientIdCard);
        record.setEmergencyContact(fullName, relationship, phone);
    }

    @Override
    public void upsertInsurance(String patientIdCard, String company, String policyNumber, boolean active,
                                LocalDate expiration) throws Exception {
        PatientRecord record = patients.get(patientIdCard);
        if (record == null) throw new Exception("Patient not found: " + patientIdCard);
        record.setInsurance(company, policyNumber, active, expiration);
    }

    // ----- Clases internas auxiliares -----
    private static class PatientRecord {
        String username;
        String fullName;
        LocalDate birthDate;
        String gender;
        String address;
        String phone;
        String email;

        EmergencyContact emergencyContact;
        Insurance insurance;

        PatientRecord(String username, String fullName, LocalDate birthDate, String gender,
                      String address, String phone, String email) {
            this.username = username;
            this.fullName = fullName;
            this.birthDate = birthDate;
            this.gender = gender;
            this.address = address;
            this.phone = phone;
            this.email = email;
        }

        void setEmergencyContact(String fullName, String relationship, String phone) {
            this.emergencyContact = new EmergencyContact(fullName, relationship, phone);
        }

        void setInsurance(String company, String policyNumber, boolean active, LocalDate expiration) {
            this.insurance = new Insurance(company, policyNumber, active, expiration);
        }
    }

    private static class AppointmentRecord {
        String patientIdCard;
        String doctorIdCard;
        LocalDate date;

        AppointmentRecord(String patientIdCard, String doctorIdCard, LocalDate date) {
            this.patientIdCard = patientIdCard;
            this.doctorIdCard = doctorIdCard;
            this.date = date;
        }
    }

    private static class EmergencyContact {
        String fullName;
        String relationship;
        String phone;
        EmergencyContact(String fullName, String relationship, String phone) {
            this.fullName = fullName;
            this.relationship = relationship;
            this.phone = phone;
        }
    }

    private static class Insurance {
        String company;
        String policyNumber;
        boolean active;
        LocalDate expiration;
        Insurance(String company, String policyNumber, boolean active, LocalDate expiration) {
            this.company = company;
            this.policyNumber = policyNumber;
            this.active = active;
            this.expiration = expiration;
        }
    }
}
