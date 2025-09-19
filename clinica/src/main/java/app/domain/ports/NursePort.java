package app.domain.ports;

import java.time.LocalDateTime;

public interface NursePort {
    void recordVitalSigns(String patientIdCard, LocalDateTime at, String bloodPressure, String temperature,
            String pulse, String oxygenLevel) throws Exception;

    void recordAdministeredMedication(String patientIdCard, LocalDateTime at, String orderNumber, int itemNumber,
            String medicationName, String dose) throws Exception;

    void recordPerformedProcedure(String patientIdCard, LocalDateTime at, String orderNumber, int itemNumber,
            String procedureName, String notes) throws Exception;

    void addObservation(String patientIdCard, LocalDateTime at, String observation) throws Exception;
}
