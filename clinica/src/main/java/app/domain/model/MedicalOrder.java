package app.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicalOrder {
    private String orderId;       // identificador único de la orden
    private String patientId;     // cédula/ID del paciente
    private String doctorId;      // cédula/ID del médico que la emitió
    private LocalDate date;       // fecha de creación de la orden

    private List<String> medications;   // lista de medicamentos recetados
    private List<String> procedures;    // lista de procedimientos
    private List<String> diagnostics;   // ayudas diagnósticas solicitadas

    public MedicalOrder(String orderId, String patientId, String doctorId, LocalDate date) {
        this.orderId = orderId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.medications = new ArrayList<>();
        this.procedures = new ArrayList<>();
        this.diagnostics = new ArrayList<>();
    }

    // Getters
    public String getOrderId() { return orderId; }
    public String getPatientId() { return patientId; }
    public String getDoctorId() { return doctorId; }
    public LocalDate getDate() { return date; }
    public List<String> getMedications() { return medications; }
    public List<String> getProcedures() { return procedures; }
    public List<String> getDiagnostics() { return diagnostics; }

    // Métodos auxiliares
    public void addMedication(String medication) { medications.add(medication); }
    public void addProcedure(String procedure) { procedures.add(procedure); }
    public void addDiagnostic(String diagnostic) { diagnostics.add(diagnostic); }

    @Override
    public String toString() {
        return "Orden medica{" +
                "Id del orden='" + orderId + '\'' +
                ", Id del paciente='" + patientId + '\'' +
                ", Id del doctor='" + doctorId + '\'' +
                ", fecha=" + date +
                ", medicaciones=" + medications +
                ", procedimientos=" + procedures +
                ", diagnosticos=" + diagnostics +
                '}';
    }
}
