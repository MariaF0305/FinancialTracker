package com.unihack.financetracker.finance_tracker_backend.repository;

import com.unihack.financetracker.finance_tracker_backend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
