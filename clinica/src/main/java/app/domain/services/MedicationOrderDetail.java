// =======================
// MedicationOrderDetail
// =======================

package app.domain.services;
public class MedicationOrderDetail extends OrderItem {
    private String medicationName;
    private int quantity;

    public MedicationOrderDetail() {}

    public MedicationOrderDetail(int id, String description, String medicationName, int quantity) {
        super(id, description);
        this.medicationName = medicationName;
        this.quantity = quantity;
    }

    public String getMedicationName() { return medicationName; }
    public void setMedicationName(String medicationName) { this.medicationName = medicationName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "MedicationOrderDetail{" +
                "id=" + getId() +
                ", description='" + getDescription() + '\'' +
                ", medicationName='" + medicationName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
