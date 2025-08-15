package app.domain.model.valueobjects;
import java.util.Objects;

public class NationalId {
    private final String value;

    public NationalId(String value) {
        if (value == null || !value.matches("\\d{1,10}")) {
            throw new IllegalArgumentException("National ID must be 1 to 10 digits.");
        }
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NationalId)) return false;
        NationalId that = (NationalId) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
