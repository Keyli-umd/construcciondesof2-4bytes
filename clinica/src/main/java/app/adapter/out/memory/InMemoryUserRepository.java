package app.adapter.out.memory;

import app.application.port.out.UserRepository;
import app.domain.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> storage = new HashMap<>();

    @Override
    public void save(User user) {
        storage.put(user.getIdNumber(), user);
    }

    @Override
    public Optional<User> findById(String idNumber) {
        return Optional.ofNullable(storage.get(idNumber));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return storage.values().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return storage.values().stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    @Override
    public void deleteById(String idNumber) {
        storage.remove(idNumber);
    }
}
