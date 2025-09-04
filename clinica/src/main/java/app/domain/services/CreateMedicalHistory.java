package app.domain.services;

import java.time.LocalDateTime;
import app.domain.ports.MedicalHistoryPort;

public class CreateMedicalHistory {

    private final MedicalHistoryPort medicalHistoryPort;

    public CreateMedicalHistory(MedicalHistoryPort medicalHistoryPort) {
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
}
