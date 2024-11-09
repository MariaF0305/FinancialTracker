package com.unihack.financetracker.finance_tracker_backend.repository;

import com.unihack.financetracker.finance_tracker_backend.entity.Leaderboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaderboardRepository extends JpaRepository<Leaderboard, Long> {

}
