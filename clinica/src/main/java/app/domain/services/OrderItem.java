// =======================
// Abstract OrderItem
// =======================
package app.domain.services;
public abstract class OrderItem {
    private int id;
    private String description;

    public OrderItem() {}

    public OrderItem(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
