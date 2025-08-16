package app.domain.model.inventory;

import java.util.Objects;

public class Specialty {
    private final String id;
    private final String name;

    public Specialty(String id, String name) {
        if (id == null || id.isBlank())
            throw new IllegalArgumentException("id cannot be blank");
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("name cannot be blank");
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
