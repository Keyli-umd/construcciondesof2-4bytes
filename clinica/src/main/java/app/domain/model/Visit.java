package app.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class Visit {
    private LocalDateTime dateTime;
    private String bloodPressure;
    private double temperature;
    private int pulse;
    private int oxygenLevel;
    private String observations;
    private List<String> medicationsAdministered;
    private List<String> proceduresPerformed;

    public Visit(LocalDateTime dateTime, String bloodPressure, double temperature,
                 int pulse, int oxygenLevel, String observations,
                 List<String> medicationsAdministered, List<String> proceduresPerformed) {
        this.dateTime = dateTime;
        this.bloodPressure = bloodPressure;
        this.temperature = temperature;
        this.pulse = pulse;
        this.oxygenLevel = oxygenLevel;
        this.observations = observations;
        this.medicationsAdministered = medicationsAdministered;
        this.proceduresPerformed = proceduresPerformed;
    }

    // Getters
    public LocalDateTime getDateTime() { return dateTime; }
    public String getBloodPressure() { return bloodPressure; }
    public double getTemperature() { return temperature; }
    public int getPulse() { return pulse; }
    public int getOxygenLevel() { return oxygenLevel; }
    public String getObservations() { return observations; }
    public List<String> getMedicationsAdministered() { return medicationsAdministered; }
    public List<String> getProceduresPerformed() { return proceduresPerformed; }

    @Override
    public String toString() {
        return "Visita{" +
                "Fecha=" + dateTime +
                ", Presion Sanguinea='" + bloodPressure + '\'' +
                ", temperatura=" + temperature +
                ", pulss=" + pulse +
                ", Nivel de oxygeno=" + oxygenLevel +
                ", observaciones='" + observations + '\'' +
                ", medicaciones=" + medicationsAdministered +
                ", procedimientos=" + proceduresPerformed +
                '}';
    }
}
