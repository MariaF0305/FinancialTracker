package com.unihack.financetracker.finance_tracker_backend.service;

import com.unihack.financetracker.finance_tracker_backend.entity.Course;
import com.unihack.financetracker.finance_tracker_backend.entity.Quiz;
import com.unihack.financetracker.finance_tracker_backend.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Quiz addQuizToCourse(Long courseId, Quiz quiz) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            quiz.setCourse(course);
            course.getQuizzes().add(quiz);
            courseRepository.save(course);
            return quiz;
        } else {
            throw new RuntimeException("User not found with ID: " + courseId);
        }
    }

    public Course updateCourse(Long id, Course course) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (existingCourse.isPresent()) {
            Course courseToUpdate = existingCourse.get();
            courseToUpdate.setTitle(course.getTitle());
            courseToUpdate.setDescription(course.getDescription());
            courseToUpdate.setDifficultyLevel(course.getDifficultyLevel());
            courseToUpdate.setContentUrl(course.getContentUrl());
            return courseRepository.save(courseToUpdate);
        } else {
            throw new IllegalArgumentException("Course not found with id: " + id);
        }
    }

    public Course findCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

}
