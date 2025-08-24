package app.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import app.domain.services.OrderItem;

public class Order {

    // Attributes
    private String orderNumber;     // Max 6 digits, unique at system level (uniqueness validation outside this class)
    private String patientId;
    private String doctorId;
    private LocalDate creationDate;
    private List<OrderItem> items;  // Items (medications, procedures, or diagnostic aids)

    // Empty constructor
    public Order() {
        this.items = new ArrayList<>();
    }

    // Constructor with parameters
    public Order(String orderNumber, String patientId, String doctorId, LocalDate creationDate) {
        setOrderNumber(orderNumber);
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.creationDate = creationDate;
        this.items = new ArrayList<>();
    }

    // Getters and Setters
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        if (orderNumber == null || !orderNumber.matches("\\d{1,6}")) {
            throw new IllegalArgumentException("Invalid order number: must be between 1 and 6 digits.");
        }
        this.orderNumber = orderNumber;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = (items != null) ? items : new ArrayList<>();
    }

    // toString
    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", creationDate=" + creationDate +
                ", items=" + (items != null ? items.size() : 0) +
                '}';
    }
}
