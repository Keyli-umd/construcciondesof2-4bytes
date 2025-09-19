package app.domain.services;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.HRServicePort;
import app.application.port.out.UserRepository;

public class HRService implements HRServicePort {

    private final UserRepository userRepository;

    public HRService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String createUser(String fullName, String idCard, String email, String phone, String address) throws Exception {
        // Validaciones de unicidad
        if (userRepository.findById(idCard).isPresent()) {
            throw new Exception("User with ID already exists: " + idCard);
        }
        if (userRepository.findByEmail(email).isPresent()) {
            throw new Exception("User with email already exists: " + email);
        }

        User newUser = new User(fullName, idCard, email, phone, null, address, null); // role se asigna después
        userRepository.save(newUser);
        return idCard;
    }

    @Override
    public void deleteUser(String idCard) throws Exception {
        if (userRepository.findById(idCard).isEmpty()) {
            throw new Exception("User not found: " + idCard);
        }
        userRepository.deleteById(idCard);
    }

    @Override
    public void assignRole(String idCard, Role role) throws Exception {
        User user = userRepository.findById(idCard)
                .orElseThrow(() -> new Exception("User not found: " + idCard));
        user.setRole(role);
        userRepository.save(user);
    }
}
