package app.application.usecases;

import app.domain.services.MedicalHistoryService;

import java.time.LocalDateTime;

public class ManageMedicalHistoryUseCase {
    private final MedicalHistoryService medicalHistoryService;

    public ManageMedicalHistoryUseCase(MedicalHistoryService medicalHistoryService) {
        this.medicalHistoryService = medicalHistoryService;
    }

    public String addAttention(String patientIdCard, LocalDateTime dateTime, String doctorIdCard,
                               String reason, String symptoms, String diagnosis) throws Exception {
        return medicalHistoryService.recordAttention(patientIdCard, dateTime, doctorIdCard, reason, symptoms, diagnosis);
    }

    public String addFollowUp(String patientIdCard, LocalDateTime dateTime, String doctorIdCard,
                              String finalDiagnosis) throws Exception {
        return medicalHistoryService.recordFollowUp(patientIdCard, dateTime, doctorIdCard, finalDiagnosis);
    }
}
