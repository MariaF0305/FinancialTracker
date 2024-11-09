package com.unihack.financetracker.finance_tracker_backend.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "userprogress")
public class UserProgress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Integer score;
    private LocalDate dateCompleted;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public UserProgress() {
    }

    public UserProgress(Long id, Integer score, LocalDate dateCompleted, User user, Course course, Quiz quiz) {
        this.id = id;
        this.score = score;
        this.dateCompleted = dateCompleted;
        this.user = user;
        this.course = course;
        this.quiz = quiz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public String toString() {
        return "UserProgress{" +
                "id=" + id +
                ", score=" + score +
                ", dateCompleted=" + dateCompleted +
                ", user=" + user +
                ", course=" + course +
                ", quiz=" + quiz +
                '}';
    }
}
