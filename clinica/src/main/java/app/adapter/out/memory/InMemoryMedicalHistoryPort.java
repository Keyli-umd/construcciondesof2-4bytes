package app.adapter.out.memory;

import app.domain.ports.MedicalHistoryPort;

import java.time.LocalDateTime;
import java.util.*;

public class InMemoryMedicalHistoryPort implements MedicalHistoryPort {

    // Estructura: patientIdCard -> lista de registros de atención
    private final Map<String, List<AttentionRecord>> medicalHistory = new HashMap<>();

    @Override
    public String saveAttention(String patientIdCard, LocalDateTime dateTime, String doctorIdCard,
                                String reason, String symptoms, String diagnosis) throws Exception {
        AttentionRecord record = new AttentionRecord(dateTime, doctorIdCard, reason, symptoms, diagnosis, null);
        medicalHistory
                .computeIfAbsent(patientIdCard, k -> new ArrayList<>())
                .add(record);

        return "ATT-" + patientIdCard + "-" + dateTime.toString();
    }

    @Override
    public String saveFollowUpAfterDiagnostic(String patientIdCard, LocalDateTime dateTime, String doctorIdCard,
                                              String finalDiagnosis) throws Exception {
        AttentionRecord record = new AttentionRecord(dateTime, doctorIdCard, null, null, finalDiagnosis, "Follow-up");
        medicalHistory
                .computeIfAbsent(patientIdCard, k -> new ArrayList<>())
                .add(record);

        return "FUP-" + patientIdCard + "-" + dateTime.toString();
    }

    // Método extra para obtener historial
    public List<AttentionRecord> getHistory(String patientIdCard) {
        return medicalHistory.getOrDefault(patientIdCard, Collections.emptyList());
    }

    // Clase interna que modela un registro de atención
    public static class AttentionRecord {
        private final LocalDateTime dateTime;
        private final String doctorIdCard;
        private final String reason;
        private final String symptoms;
        private final String diagnosis;
        private final String type; // "Attention" o "Follow-up"

        public AttentionRecord(LocalDateTime dateTime, String doctorIdCard,
                               String reason, String symptoms, String diagnosis, String type) {
            this.dateTime = dateTime;
            this.doctorIdCard = doctorIdCard;
            this.reason = reason;
            this.symptoms = symptoms;
            this.diagnosis = diagnosis;
            this.type = type != null ? type : "Attention";
        }

        public LocalDateTime getDateTime() { return dateTime; }
        public String getDoctorIdCard() { return doctorIdCard; }
        public String getReason() { return reason; }
        public String getSymptoms() { return symptoms; }
        public String getDiagnosis() { return diagnosis; }
        public String getType() { return type; }

        @Override
        public String toString() {
            return "AttentionRecord{" +
                    "dateTime=" + dateTime +
                    ", doctorIdCard='" + doctorIdCard + '\'' +
                    ", reason='" + reason + '\'' +
                    ", symptoms='" + symptoms + '\'' +
                    ", diagnosis='" + diagnosis + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}

