package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class MedicalHistory {
    private String patientId;  // clave del paciente
    private List<MedicalCare> visits;

    public MedicalHistory(String patientId) {
        this.patientId = patientId;
        this.visits = new ArrayList<>();
    }

    public String getPatientId() { return patientId; }
    public List<MedicalCare> getVisits() { return visits; }

    public void addVisit(MedicalCare care) {
        visits.add(care);
    }

    @Override
    public String toString() {
        return "MedicalHistory{" +
                "patientId='" + patientId + '\'' +
                ", visits=" + visits +
                '}';
    }
}
