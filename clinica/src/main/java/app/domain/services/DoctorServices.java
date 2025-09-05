package app.domain.services;

import java.time.LocalDateTime;
import app.domain.ports.DoctorPort;
import app.domain.ports.MedicalHistoryPort;
import app.domain.ports.PatientPort;

public class DoctorServices {
    private DoctorPort doctorPort;
    private MedicalHistoryPort medicalHistoryPort;
    private PatientPort patientPort;

    // CreateOrder
    public void CreateOrder(DoctorPort doctorPort) {
        this.doctorPort = doctorPort;
    }

    public String execute(String patientIdCard, String doctorIdCard,
            LocalDateTime createdAt, String type) throws Exception {
        if (createdAt == null) {
            throw new Exception("createdAt is required");
        }
        return doctorPort.createOrder(patientIdCard, doctorIdCard, createdAt);
    }

    // UpdateMedicalHistory
    public void UpdateMedicalHistory(MedicalHistoryPort medicalHistoryPort) {
        this.medicalHistoryPort = medicalHistoryPort;
    }

    public void execute(String recordId, String doctorIdCard,
            LocalDateTime updatedAt, String updatedDiagnosis,
            String updatedTreatment) throws Exception {
        if (recordId == null || recordId.isBlank()) {
            throw new Exception("recordId is required");
        }
        /*
         * Aquí la idea es usar el port para actualizar un registro médico existente
         * Podrías extender MedicalRecordPort con un método update en la siguiente fase
         * Ejemplo: medicalHistoryPort.update(recordId, ...)
         */
        throw new UnsupportedOperationException("Update not implemented yet");
    }

    // CreateMedicalHistory
    public void CreateMedicalHistory(MedicalHistoryPort medicalHistoryPort) {
        this.medicalHistoryPort = medicalHistoryPort;
    }

    public String execute(String patientIdCard, String doctorIdCard,
            LocalDateTime dateTime, String reason,
            String symptoms, String diagnosis) throws Exception {
        if (dateTime == null) {
            throw new Exception("dateTime is required");
        }
        return medicalHistoryPort.saveAttention(patientIdCard, dateTime, doctorIdCard,
                reason, symptoms, diagnosis);
    }

    // FindPatient
    public void FindPatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public String execute(String idCard) throws Exception {
        if (idCard == null || idCard.isBlank()) {
            throw new Exception("idCard is required");
        }
        return patientPort.findIdByIdCard(idCard);
    }
}
