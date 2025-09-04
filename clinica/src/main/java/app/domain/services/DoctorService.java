package app.domain.services;

import app.domain.model.*;
import java.time.LocalDate;
import java.util.*;

public class DoctorService {
    private Map<String, Patient> patients = new HashMap<>();
    private Map<String, MedicalHistory> histories = new HashMap<>();
    private Map<String, Order> orders = new HashMap<>();

    public Patient findPatient(String idCard) {
        return patients.get(idCard);
    }

    public void createMedicalRecord(String patientId, String doctorId, String reason, String symptoms, String diagnosis) {
        MedicalCare care = new MedicalCare(LocalDate.now(), doctorId, reason, symptoms, diagnosis);
        histories.computeIfAbsent(patientId, k -> new MedicalHistory(patientId)).addVisit(care);
    }

    //public void updateMedicalRecord(String patientId, int index, String newDiagnosis) {
       // MedicalHistory history = histories.get(patientId);
        //if (history != null && index < history.getVisits().size()) {
        //    history.getVisits().get(index).setDiagnosis(newDiagnosis);
        //} else {
       //     throw new IllegalArgumentException("Medical record not found");
        //}
    //}

    public void createOrder(Order order) {
        orders.put(order.getOrderNumber(), order);
    }
}
