package app.domain.services;

import app.domain.ports.MedicalHistoryPort;

import java.time.LocalDateTime;

public class MedicalHistoryService {
    private final MedicalHistoryPort medicalHistoryPort;

    public MedicalHistoryService(MedicalHistoryPort medicalHistoryPort) {
        this.medicalHistoryPort = medicalHistoryPort;
    }

    public String recordAttention(String patientIdCard, LocalDateTime dateTime, String doctorIdCard,
                                  String reason, String symptoms, String diagnosis) throws Exception {
        return medicalHistoryPort.saveAttention(patientIdCard, dateTime, doctorIdCard, reason, symptoms, diagnosis);
    }

    public String recordFollowUp(String patientIdCard, LocalDateTime dateTime, String doctorIdCard,
                                 String finalDiagnosis) throws Exception {
        return medicalHistoryPort.saveFollowUpAfterDiagnostic(patientIdCard, dateTime, doctorIdCard, finalDiagnosis);
    }
}
