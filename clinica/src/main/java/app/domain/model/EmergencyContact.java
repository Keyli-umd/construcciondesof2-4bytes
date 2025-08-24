package app.domain.model;

public class EmergencyContact {
    private String name;
    private String telephone ;
    private String kinship;

    public EmergencyContact() { }

    public EmergencyContact(String name, String telephone, String kinship) {
        this.name = name;
        this.telephone = telephone;
        this.kinship = kinship;

    }

    public String getName() { return name; }
    public void setName(String name) {if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) {
        if (telephone == null || telephone.length() != 10 || !telephone.chars().allMatch(Character::isDigit)) {
        throw new IllegalArgumentException("Emergency contact phone must be exactly 10 digits.");
        }
        this.telephone = telephone;
    }

    public String getKinship() { return kinship; }
    public void setKinship(String kinship) { this.kinship = kinship; }

    @Override
    public String toString() {
        return "EmergencyContact{" +
                "name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", kinship='" + kinship + '\'' +
                '}';
    }
}