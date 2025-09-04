package app.domain.services;

import java.time.LocalDateTime;
import app.domain.ports.DoctorPort;

public class CreateOrder {

    private final DoctorPort doctorPort;

    public CreateOrder(DoctorPort doctorPort) {
        this.doctorPort = doctorPort;
    }

    public String execute(String patientIdCard, String doctorIdCard,
            LocalDateTime createdAt, String type) throws Exception {
        if (createdAt == null) {
            throw new Exception("createdAt is required");
        }
        return doctorPort.createOrder(patientIdCard, doctorIdCard, createdAt);
    }
}
