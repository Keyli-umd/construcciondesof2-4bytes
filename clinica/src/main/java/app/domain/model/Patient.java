package app.domain.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Patient {
    private String idCard;         // único
    private String fullName;
    private LocalDate birthDate;   // máximo 150 años
    private String gender;         // masculino, femenino, otro
    private String address;
    private String phoneNumber;    // exactamente 10 dígitos
    private String email;          // opcional
    private EmergencyContact emergencyContact;
    private MedicalInsurance medicalInsurance;

    public Patient(String idCard, String fullName, LocalDate birthDate, String gender,
                   String address, String phoneNumber, String email) {
        validateId(idCard);
        validateBirthDate(birthDate);
        validatePhoneNumber(phoneNumber);
        validateGender(gender);

        this.idCard = idCard;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
     private final List<Visit> visits = new ArrayList<>();
     
    public void addVisit(Visit visit) {
        if (visit == null) throw new IllegalArgumentException("visit cannot be null");
        visits.add(visit);
    }

    public List<Visit> getVisits() {
        // evita que desde fuera modifiquen la lista interna
        return Collections.unmodifiableList(visits);
    }

    public void clearVisits() {
        visits.clear();
    }

    
    // Validaciones
    private void validateId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("La id no puede estar vacia");
        }
    }

    private void validateBirthDate(LocalDate birthDate) {
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        if (age > 150) {
            throw new IllegalArgumentException("La edad no puede exceder 150");
        }
    }

    private void validatePhoneNumber(String phone) {
        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("El telefono debe tener exactamente 10 digitos");
        }
    }

    private void validateGender(String gender) {
        if (!(gender.equalsIgnoreCase("masculino") ||
              gender.equalsIgnoreCase("femenino") ||
              gender.equalsIgnoreCase("otro"))) {
            throw new IllegalArgumentException("Genero invalido");
        }
    }

    // Getters y setters
    public String getIdCard() { return idCard; }
    public String getFullName() { return fullName; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getGender() { return gender; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public EmergencyContact getEmergencyContact() { return emergencyContact; }
    public MedicalInsurance getMedicalInsurance() { return medicalInsurance; }

    public void setAddress(String address) {
        if (address != null && address.length() <= 30) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("La dirreccion no debe exceder de los 30 caracteres");
        }
    }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        if (this.emergencyContact != null) {
            throw new IllegalStateException("El paciente ya tiene un conctacto de emergencia");
        }
        this.emergencyContact = emergencyContact;
    }

    public void setMedicalInsurance(MedicalInsurance medicalInsurance) {
        if (this.medicalInsurance != null) {
            throw new IllegalStateException("El paciente ya tiene seguro medico");
        }
        this.medicalInsurance = medicalInsurance;
    }
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.matches("\\d{1,10}")) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("El numero debe ser maximo de 10 digitos");
        }
    }
    @Override
    public String toString() {
        return "Paciente{" +
                "Id='" + idCard + '\'' +
                ", Nombre completo='" + fullName + '\'' +
                ", Fecha de nacimiento=" + birthDate +
                ", Genero='" + gender + '\'' +
                ", Direccion='" + address + '\'' +
                ", Numero='" + phoneNumber + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }
}
