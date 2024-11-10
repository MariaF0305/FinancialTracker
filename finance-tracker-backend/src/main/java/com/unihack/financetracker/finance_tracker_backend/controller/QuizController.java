package com.unihack.financetracker.finance_tracker_backend.controller;

import com.unihack.financetracker.finance_tracker_backend.entity.Course;
import com.unihack.financetracker.finance_tracker_backend.entity.Quiz;
import com.unihack.financetracker.finance_tracker_backend.service.CourseService;
import com.unihack.financetracker.finance_tracker_backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/quiz")
public class QuizController {
    @Autowired
    private CourseService courseService;
    private QuizService quizService;
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.findAllQuizzes();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable("id") Long id) {
        Quiz quiz = quizService.findQuizById(id);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @PostMapping("/course/{courseId}")
    public ResponseEntity<Quiz> addQuizToCourse(@PathVariable Long courseId, @RequestBody Quiz quiz) {
        Quiz createdQuiz = courseService.addQuizToCourse(courseId, quiz);
        return ResponseEntity.ok(createdQuiz);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable("id") Long id, @RequestBody Quiz quiz) {
        Quiz updateQuiz = quizService.updateQuiz(id, quiz);
        return new ResponseEntity<>(quizService.updateQuiz(id, quiz), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuiz(@PathVariable("id") Long id) {
        quizService.deleteQuizById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
