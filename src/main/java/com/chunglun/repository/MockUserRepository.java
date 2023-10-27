package com.chunglun.repository;

import com.chunglun.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MockUserRepository {
    private final List<User> userDB = new ArrayList<>();

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
