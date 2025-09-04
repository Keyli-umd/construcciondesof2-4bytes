package app.domain.services;

import java.time.LocalDateTime;
import app.domain.ports.MedicalHistoryPort;

public class UpdateMedicalHistory {

    private final MedicalHistoryPort medicalHistoryPort;

    public UpdateMedicalHistory(MedicalHistoryPort medicalHistoryPort) {
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
}
