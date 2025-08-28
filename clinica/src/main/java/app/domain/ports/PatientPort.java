package app.domain.ports;

public interface PatientPort {
    String findIdByIdCard(String idCard) throws Exception;

    void updateContact(String idCard, String address, String phone, String email) throws Exception;
}
