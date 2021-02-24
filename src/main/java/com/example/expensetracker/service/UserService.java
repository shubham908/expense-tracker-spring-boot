package com.example.expensetracker.service;

import com.example.expensetracker.entity.User;
import com.example.expensetracker.exception.UserNotFoundException;
import com.example.expensetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException(String.format("User with id {%d} does not exist", id));
        }
        else {
            return user.get();
        }
    }

    public User addUser(User user) {
        final User savedUser = userRepository.save(user);
        return savedUser;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
