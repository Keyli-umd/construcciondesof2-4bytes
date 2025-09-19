package app.adapter.out.memory;

import app.domain.ports.NursePort;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryNursePort implements NursePort {

    private final List<String> logs = new ArrayList<>();

    @Override
    public void recordVitalSigns(String patientIdCard, LocalDateTime at, String bloodPressure,
                                 String temperature, String pulse, String oxygenLevel) throws Exception {
        logs.add("Vitals for " + patientIdCard + " at " + at + ": " + bloodPressure + "/" +
                temperature + "/" + pulse + "/" + oxygenLevel);
    }

    @Override
    public void recordAdministeredMedication(String patientIdCard, LocalDateTime at, String orderNumber, int itemNumber,
                                             String medicationName, String dose) throws Exception {
        logs.add("Medication administered to " + patientIdCard + " order " + orderNumber +
                " item " + itemNumber + ": " + medicationName + " (" + dose + ")");
    }

    @Override
    public void recordPerformedProcedure(String patientIdCard, LocalDateTime at, String orderNumber, int itemNumber,
                                         String procedureName, String notes) throws Exception {
        logs.add("Procedure for " + patientIdCard + " order " + orderNumber + " item " + itemNumber +
                ": " + procedureName + " Notes: " + notes);
    }

    @Override
    public void addObservation(String patientIdCard, LocalDateTime at, String observation) throws Exception {
        logs.add("Observation for " + patientIdCard + " at " + at + ": " + observation);
    }

    public List<String> getLogs() {
        return logs;
    }
}
