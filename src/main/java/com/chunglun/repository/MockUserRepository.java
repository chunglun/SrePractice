package com.chunglun.repository;

import com.chunglun.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MockUserRepository {
    private final List<User> userDB = new ArrayList<>();

    @PostConstruct
    private void initDB() {
        userDB.add(new User("000138000465688", "Nike", "Shih Tzu", 2007));
    }

    public User insert(User user) {
        userDB.add(user);
        return user;
    }

    public void delete(String userId) {
        userDB.removeIf(p -> p.getUserId().equals(userId));
    }

    public Optional<User> find(String userId) {
        return userDB.stream()
                .filter(p -> p.getUserId().equals(userId))
                .findFirst();
    }
}
