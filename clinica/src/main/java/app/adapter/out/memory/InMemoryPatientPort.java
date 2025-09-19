package app.adapter.out.memory;

import app.domain.ports.PatientPort;

import java.util.HashMap;
import java.util.Map;

public class InMemoryPatientPort implements PatientPort {

    private final Map<String, String> idByIdCard = new HashMap<>();  
    // Aqui guardamos: idCard → patientId (puede ser el mismo idCard o algún identificador interno)
    private final Map<String, PatientData> patients = new HashMap<>();

    @Override
    public String findIdByIdCard(String idCard) throws Exception {
        return idByIdCard.get(idCard);
    }

    @Override
    public void updateContact(String idCard, String address, String phone, String email) throws Exception {
        PatientData pd = patients.get(idCard);
        if (pd == null) {
            throw new Exception("Patient not found with ID Card: " + idCard);
        }
        pd.setAddress(address);
        pd.setPhone(phone);
        pd.setEmail(email);
    }

    // Clase interna auxiliar para almacenar datos de paciente
    private static class PatientData {
        private String address;
        private String phone;
        private String email;
        // get & set
        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }
        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }
}
