package app.domain.model;

import java.time.LocalDate;
import java.time.Period;

public class User {
    private String fullName;
    private String idNumber;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private String address;
    private String role;
    private String username;
    private String password;

    // Constructor con validaciones
    public User(String fullName, String idNumber, String email, String phoneNumber,
                LocalDate birthDate, String address, String role,
                String username, String password) {
        setFullName(fullName);
        setIdNumber(idNumber);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setBirthDate(birthDate);
        setAddress(address);
        setRole(role);
        setUsername(username);
        setPassword(password);
    }

    // ----------------- VALIDACIONES -----------------

    private void validateNotEmpty(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " No puede estar vacio.");
        }
    }

    private void validateEmail(String email) {
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Formato de email Invalido.");
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d{1,10}")) {
            throw new IllegalArgumentException("El numero de telefono debe tener entre 1-10 digitos.");
        }
    }

    private void validateBirthDate(LocalDate birthDate) {
        LocalDate now = LocalDate.now();
        int age = Period.between(birthDate, now).getYears();
        if (age > 150 || age < 0) {
            throw new IllegalArgumentException("Fecha de nacimiento invalida, la edad debe ser entre 0-150.");
        }
    }

    private void validateAddress(String address) {
        if (address.length() > 30) {
            throw new IllegalArgumentException("La direccion debe tener 30 caracteres como maximo.");
        }
    }

    private void validateUsername(String username) {
        if (!username.matches("^[a-zA-Z0-9]{1,15}$")) {
            throw new IllegalArgumentException("El nombre de usuario debe ser unico, maximo 15 caracteres y solo debe contener letras y numeros.");
        }
    }

    private void validatePassword(String password) {
        if (!password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{8,}$")) {
            throw new IllegalArgumentException("La contraseña debe incluir una mayuscula, un numero, un caracter especial y contener por lo menos 8 caracteres.");
        }
    }

    // ----------------- GETTERS Y SETTERS -----------------

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        validateNotEmpty(fullName, "Nombre Completo");
        this.fullName = fullName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        validateNotEmpty(idNumber, "Numero de ID");
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        validateBirthDate(birthDate);
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        validateNotEmpty(role, "Rol");
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        validateUsername(username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        validatePassword(password);
        this.password = password;
    }

    // ToString (sin contraseña por seguridad)
    @Override
    public String toString() {
        return "Usuario{" +
                "Nombre Completo='" + fullName + '\'' +
                ", Numero de id='" + idNumber + '\'' +
                ", Email='" + email + '\'' +
                ", Numero telefonico='" + phoneNumber + '\'' +
                ", Fecha de nacimiento=" + birthDate +
                ", Dirección='" + address + '\'' +
                ", Rol='" + role + '\'' +
                ", Nombre de usuario='" + username + '\'' +
                '}';
    }
}
