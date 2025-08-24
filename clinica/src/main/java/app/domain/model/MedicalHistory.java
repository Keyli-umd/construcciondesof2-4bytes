package app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class MedicalHistory {
    private String id;
    private List<MedicalCare> medicalCareRecords;

    public MedicalHistory() {
        this.medicalCareRecords = new ArrayList<>();
    }

    public MedicalHistory(String id) {
        this.id = id;
        this.medicalCareRecords = new ArrayList<>();
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public List<MedicalCare> getMedicalCareRecords() { return medicalCareRecords; }
    public void addMedicalCare(MedicalCare care) { this.medicalCareRecords.add(care); }

    @Override
    public String toString() {
        return "MedicalHistory{" +
                "id='" + id + '\'' +
                ", medicalCareRecords=" + medicalCareRecords +
                '}';
    }
}
