// =======================
// MedicationInventory
// =======================
package app.domain.services;
public class MedicationInventory {
    private int id;
    private String name;
    private int stock;

    public MedicationInventory() {}

    public MedicationInventory(int id, String name, int stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "MedicationInventory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                '}';
    }
}
