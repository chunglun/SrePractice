package com.chunglun.service;

import com.chunglun.entity.User;
import com.chunglun.object.NotFoundException;
import com.chunglun.object.UnprocessableEntityException;
import com.chunglun.repository.MockUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private MockUserRepository userRepository;

    public User createUser(User request) {
        boolean isIdDuplicated = userRepository.find(request.getUserId()).isPresent();
        if (isIdDuplicated) {
            throw new UnprocessableEntityException("The id of the user is duplicated.");
        }
        User user = new User(request);
        return userRepository.insert(user);
    }

    public User getUser(String userId) {
        return userRepository.find(userId)
                .orElseThrow(() -> new NotFoundException("Can't find user."));
    }

    public void deleteUser(String userId) {
        User user = this.getUser(userId);
        userRepository.delete(user.getUserId());
    }
}
