package com.unihack.financetracker.finance_tracker_backend.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "leaderboard")
public class Leaderboard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Integer rank;
    private Integer score;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Leaderboard() {
    }

    public Leaderboard(Long id, Integer rank, Integer score, User user) {
        this.id = id;
        this.rank = rank;
        this.score = score;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Leaderboard{" +
                "id=" + id +
                ", rank=" + rank +
                ", score=" + score +
                ", user=" + user +
                '}';
    }
}
