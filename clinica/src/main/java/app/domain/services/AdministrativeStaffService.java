package app.domain.services;

import app.domain.model.Patient;
import app.domain.model.Appointment;
import app.domain.model.Invoice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class AdministrativeStaffService {
    private Map<String, Patient> patients = new HashMap<>();
    private List<Appointment> appointments = new ArrayList<>();
    private List<Invoice> invoices = new ArrayList<>();

    public void createPatient(Patient patient) {
        patients.put(patient.getIdCard(), patient);
    }

    public void updatePatient(String idCard, String newAddress, String newPhone) {
        Patient patient = patients.get(idCard);
        if (patient != null) {
            patient.setAddress(newAddress);
            patient.setPhoneNumber(newPhone);
        } else {
            throw new IllegalArgumentException("Patient not found");
        }
    }

    public void createAppointment(String patientId, String doctorId, LocalDateTime dateTime) {
        Appointment appointment = new Appointment(patientId, doctorId, dateTime);
        appointments.add(appointment);
    }

    public Invoice createInvoice(Patient patient, String doctorName,
                             String insuranceCompany, String policyNumber,
                             long policyDaysLeft, LocalDate policyEndDate,
                             double totalCost) {
    Invoice invoice = new Invoice(
            patient.getFullName(),
            calculateAge(patient.getBirthDate()),
            patient.getIdCard(),
            doctorName,
            insuranceCompany,
            policyNumber,
            policyDaysLeft,
            policyEndDate,
            totalCost
    );
    invoices.add(invoice);
    return invoice;
}

    private int calculateAge(LocalDate birthDate) {
    return LocalDate.now().getYear() - birthDate.getYear();
}


}

