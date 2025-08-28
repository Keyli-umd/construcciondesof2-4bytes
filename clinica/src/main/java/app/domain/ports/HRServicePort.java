package app.domain.ports;

import app.domain.model.enums.Role;

public interface HRServicePort {
    String createUser(String fullName, String idCard, String email, String phone, String address) throws Exception;

    void deleteUser(String idCard) throws Exception;

    void assignRole(String idCard, Role role) throws Exception;
}
