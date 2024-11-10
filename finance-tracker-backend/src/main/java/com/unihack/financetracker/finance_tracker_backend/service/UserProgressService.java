package com.unihack.financetracker.finance_tracker_backend.service;

import com.unihack.financetracker.finance_tracker_backend.entity.User;
import com.unihack.financetracker.finance_tracker_backend.entity.UserProgress;
import com.unihack.financetracker.finance_tracker_backend.repository.CourseRepository;
import com.unihack.financetracker.finance_tracker_backend.repository.QuizRepository;
import com.unihack.financetracker.finance_tracker_backend.repository.UserProgressRepository;
import com.unihack.financetracker.finance_tracker_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProgressService {
    private final UserProgressRepository userProgressRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final QuizRepository quizRepository;

    public UserProgressService(final UserProgressRepository userProgressRepository,
                               final UserRepository userRepository,
                               final CourseRepository courseRepository,
                               final QuizRepository quizRepository) {
        this.userProgressRepository = userProgressRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.quizRepository = quizRepository;
    }

    public Optional<UserProgress> getUserProgressById(Long id) {
        return userProgressRepository.findById(id);
    }

    public UserProgress addUserProgress(UserProgress userProgress, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        user.ifPresent(userProgress::setUser);

        if (userProgress.getCourse() != null) {
            courseRepository.findById(userProgress.getCourse().getId())
                    .ifPresent(userProgress::setCourse);
        }
        if (userProgress.getQuiz() != null) {
            quizRepository.findById(userProgress.getQuiz().getId())
                    .ifPresent(userProgress::setQuiz);
        }

        return userProgressRepository.save(userProgress);
    }
}
