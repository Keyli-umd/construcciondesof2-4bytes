package app.domain.model;

import java.time.LocalDate;

public class MedicalCare {
    private LocalDate date;
    private String doctorId;
    private String reason;
    private String symptoms;
    private String diagnosis;

    public MedicalCare(LocalDate date, String doctorId, String reason, String symptoms, String diagnosis) {
        this.date = date;
        this.doctorId = doctorId;
        this.reason = reason;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
    }

    public LocalDate getDate() { return date; }
    public String getDoctorId() { return doctorId; }
    public String getReason() { return reason; }
    public String getSymptoms() { return symptoms; }
    public String getDiagnosis() { return diagnosis; }

    @Override
    public String toString() {
        return "MedicalCare{" +
                "date=" + date +
                ", doctorId='" + doctorId + '\'' +
                ", reason='" + reason + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
