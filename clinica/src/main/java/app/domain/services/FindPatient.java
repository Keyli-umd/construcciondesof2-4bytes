package app.domain.services;

import app.domain.ports.PatientPort;

public class FindPatient {

    private PatientPort patientPort;

    public FindPatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public String execute(String idCard) throws Exception {
        if (idCard == null || idCard.isBlank()) {
            throw new Exception("idCard is required");
        }
        return patientPort.findIdByIdCard(idCard);
    }
}
