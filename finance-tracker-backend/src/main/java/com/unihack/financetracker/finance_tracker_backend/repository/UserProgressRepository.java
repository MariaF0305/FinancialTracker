package com.unihack.financetracker.finance_tracker_backend.repository;

import com.unihack.financetracker.finance_tracker_backend.entity.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProgressRepository extends JpaRepository<UserProgress, Long> {
}
