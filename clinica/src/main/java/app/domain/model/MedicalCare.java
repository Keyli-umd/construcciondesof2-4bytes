package app.domain.model;

import java.time.LocalDateTime;

public class MedicalCare {
    private String id;
    private LocalDateTime dateTime;
    private Doctor doctor;
    private Nurse nurse;
    private String diagnosis;
    private String treatment;

    public MedicalCare() { }

    public MedicalCare(String id, LocalDateTime dateTime, Doctor doctor,
                       Nurse nurse, String diagnosis, String treatment) {
        this.id = id;
        this.dateTime = dateTime;
        this.doctor = doctor;
        this.nurse = nurse;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public Nurse getNurse() { return nurse; }
    public void setNurse(Nurse nurse) { this.nurse = nurse; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getTreatment() { return treatment; }
    public void setTreatment(String treatment) { this.treatment = treatment; }

    @Override
    public String toString() {
        return "MedicalCare{" +
               "id='" + id + '\'' +
                ", dateTime=" + dateTime +
                ", doctor=" + doctor +
                ", nurse=" + nurse +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }
}