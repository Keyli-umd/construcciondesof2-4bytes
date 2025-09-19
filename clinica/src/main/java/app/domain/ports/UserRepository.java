package app.application.port.out;

import app.domain.model.User;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findById(String idNumber);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    void deleteById(String idNumber);
    
}

