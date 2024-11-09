package com.unihack.financetracker.finance_tracker_backend.repository;

import com.unihack.financetracker.finance_tracker_backend.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository <Goal,Long> {
}
