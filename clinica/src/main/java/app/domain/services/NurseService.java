package app.domain.services;

import app.domain.ports.NursePort;
import java.time.LocalDateTime;

public class NurseService implements NursePort {

    private final NursePort nursePort;

    public NurseService(NursePort nursePort) {
        this.nursePort = nursePort;
    }

    @Override
    public void recordVitalSigns(String patientIdCard, LocalDateTime at, String bloodPressure, String temperature,
                                 String pulse, String oxygenLevel) throws Exception {
        nursePort.recordVitalSigns(patientIdCard, at, bloodPressure, temperature, pulse, oxygenLevel);
    }

    @Override
    public void recordAdministeredMedication(String patientIdCard, LocalDateTime at, String orderNumber, int itemNumber,
                                             String medicationName, String dose) throws Exception {
        nursePort.recordAdministeredMedication(patientIdCard, at, orderNumber, itemNumber, medicationName, dose);
    }

    @Override
    public void recordPerformedProcedure(String patientIdCard, LocalDateTime at, String orderNumber, int itemNumber,
                                         String procedureName, String notes) throws Exception {
        nursePort.recordPerformedProcedure(patientIdCard, at, orderNumber, itemNumber, procedureName, notes);
    }

    @Override
    public void addObservation(String patientIdCard, LocalDateTime at, String observation) throws Exception {
        nursePort.addObservation(patientIdCard, at, observation);
    }
}

