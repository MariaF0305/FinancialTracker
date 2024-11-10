package com.unihack.financetracker.finance_tracker_backend.controller;

import com.unihack.financetracker.finance_tracker_backend.entity.Course;
import com.unihack.financetracker.finance_tracker_backend.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.findAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Long id) {
        Course course = courseService.findCourseById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course newCourse = courseService.addCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") Long id, @RequestBody Course course) {
        Course updateCourse = courseService.updateCourse(id, course);
        return new ResponseEntity<>(courseService.updateCourse(id, course), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourseById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
