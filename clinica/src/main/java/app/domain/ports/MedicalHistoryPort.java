package app.domain.ports;

import java.time.LocalDateTime;

public interface MedicalHistoryPort {
    String saveAttention(String patientIdCard, LocalDateTime dateTime, String doctorIdCard, String reason,
            String symptoms, String diagnosis) throws Exception;

    String saveFollowUpAfterDiagnostic(String patientIdCard, LocalDateTime dateTime, String doctorIdCard,
            String finalDiagnosis) throws Exception;
}
