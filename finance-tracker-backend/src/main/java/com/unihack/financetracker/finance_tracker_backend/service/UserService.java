package com.unihack.financetracker.finance_tracker_backend.service;

import com.unihack.financetracker.finance_tracker_backend.entity.Goal;
import com.unihack.financetracker.finance_tracker_backend.entity.User;
import com.unihack.financetracker.finance_tracker_backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public Goal addGoalToUser(Long userId, Goal goal) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            goal.setUser(user);
            user.getGoals().add(goal);
            userRepository.save(user);
            return goal;
        } else {
            throw new RuntimeException("User not found with ID: " + userId);
        }
    }

    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setIncome(user.getIncome());
            userToUpdate.setKnowledgeLevel(user.getKnowledgeLevel());
            return userRepository.save(userToUpdate);
        } else {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }

    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
