package com.unihack.financetracker.finance_tracker_backend.service;

import com.unihack.financetracker.finance_tracker_backend.entity.Quiz;
import com.unihack.financetracker.finance_tracker_backend.repository.QuizRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuizService {
    private final QuizRepository quizRepository;

    @Autowired

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Quiz updateQuiz(Long id, Quiz quiz) {
        Optional<Quiz> existingQuiz = quizRepository.findById(id);
        if (existingQuiz.isPresent()) {
            Quiz quizToUpdate = existingQuiz.get();
            quizToUpdate.setTitle(quiz.getTitle());
            quizToUpdate.setTotalQuestions(quiz.getTotalQuestions());
            quizToUpdate.setPassingScores(quiz.getPassingScores());
            return quizRepository.save(quizToUpdate);
        } else {
            throw new IllegalArgumentException("Quiz not found with id: " + id);
        }
    }

    public Quiz findQuizById(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        return quiz.orElseThrow(() -> new RuntimeException("Quiz not found"));
    }

    public List<Quiz> findAllQuizzes() {
        return quizRepository.findAll();
    }

    public void deleteQuizById(Long id) {
        quizRepository.deleteById(id);
    }
}
