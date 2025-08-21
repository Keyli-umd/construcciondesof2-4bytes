package app.domain.model.inventory;

import java.util.Objects;

public abstract class InventoryItem {
    private String id;
    private String name;
    private double price;

    protected InventoryItem(String id, String name, double price) {
        setId(id);
        setName(name);
        setPrice(price);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        if (id == null || id.isBlank())
            throw new IllegalArgumentException("id cannot be blank");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("name cannot be blank");
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("price cannot be negative");
        this.price = price;
    }
}
