package com.unihack.financetracker.finance_tracker_backend.service;

import com.unihack.financetracker.finance_tracker_backend.entity.Leaderboard;
import com.unihack.financetracker.finance_tracker_backend.entity.User;
import com.unihack.financetracker.finance_tracker_backend.repository.LeaderboardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LeaderboardService {
    private final LeaderboardRepository leaderboardRepository;

    @Autowired
    public LeaderboardService(LeaderboardRepository leaderboardRepository) {
        this.leaderboardRepository = leaderboardRepository;
    }

    public Leaderboard addLeaderboard(Leaderboard leaderboard) {
        return leaderboardRepository.save(leaderboard);
    }

    public Leaderboard updateLeaderboardEntry(Long id, Leaderboard updatedEntry) {
        return leaderboardRepository.findById(id).map(entry -> {
            entry.setRank(updatedEntry.getRank());
            entry.setScore(updatedEntry.getScore());
            entry.setUser(updatedEntry.getUser());
            return leaderboardRepository.save(entry);
        }).orElseThrow(() -> new IllegalArgumentException("Leaderboard entry not found with id: " + id));
    }

    public Leaderboard getLeaderboardEntryById(Long id) {
        return leaderboardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Leaderboard entry not found with id: " + id));
    }

    public void deleteLeaderboardEntry(Long id) {
        leaderboardRepository.deleteById(id);
    }
}
