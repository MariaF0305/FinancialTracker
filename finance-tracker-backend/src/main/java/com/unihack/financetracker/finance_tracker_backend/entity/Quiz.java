package com.unihack.financetracker.finance_tracker_backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "quiz")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Quiz implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String title;
    private Integer totalQuestions;
    private Double passingScores;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    @JsonBackReference
    private Course course;

    public Quiz() {
    }

    public Quiz(Long id, String title, Integer totalQuestions, Double passingScores, Course course) {
        this.id = id;
        this.title = title;
        this.totalQuestions = totalQuestions;
        this.passingScores = passingScores;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(Integer totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public Double getPassingScores() {
        return passingScores;
    }

    public void setPassingScores(Double passingScores) {
        this.passingScores = passingScores;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", totalQuestions=" + totalQuestions +
                ", passingScores=" + passingScores +
                ", course=" + course +
                '}';
    }
}
