package app.domain.services;

import app.domain.model.Patient;
import app.domain.model.Visit;
import app.domain.model.MedicalOrder;
import java.util.List;

public class NurseService {
    private final List<Patient> patients;
    private final List<MedicalOrder> orders;

    public NurseService(List<Patient> patients, List<MedicalOrder> orders) {
        this.patients = patients;
        this.orders = orders;
    }

    // Registrar visita
    public void registerVisit(String patientId, Visit visit) {
    for (Patient p : patients) {
        if (p.getIdCard().equals(patientId)) {   // antes era getId()
            p.addVisit(visit);
            System.out.println("Visit registered for patient: " + p.getFullName()); // antes era getName()
            return;
        }
    }
    throw new IllegalArgumentException("Patient with ID " + patientId + " not found.");
}


    // Buscar orden médica
    public MedicalOrder findOrder(String orderId) {
        for (MedicalOrder order : orders) {
            if (order.getOrderId().equals(orderId)) {
                return order;
            }
        }
        throw new IllegalArgumentException("Order with ID " + orderId + " not found.");
    }

    // Buscar paciente
    public Patient findPatient(String patientId) {
        for (Patient p : patients) {
            if (p.getIdCard().equals(patientId)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Patient with ID " + patientId + " not found.");
    }
}
