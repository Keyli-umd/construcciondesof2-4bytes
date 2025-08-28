package app.domain.ports;

import java.time.LocalDateTime;

public interface DoctorPort {
    String createOrder(String patientIdCard, String doctorIdCard, LocalDateTime createdAt) throws Exception;

    void prescribeMedication(String orderNumber, int itemNumber, String medicationId, String dose, String duration)
            throws Exception;

    void prescribeProcedure(String orderNumber, int itemNumber, String procedureId, int times, String frequency,
            boolean requiresSpecialist, String specialtyId) throws Exception;

    void prescribeDiagnosticAid(String orderNumber, int itemNumber, String aidId, int quantity,
            boolean requiresSpecialist, String specialtyId) throws Exception;
}
