package com.unihack.financetracker.finance_tracker_backend.service;

import com.unihack.financetracker.finance_tracker_backend.entity.Goal;
import com.unihack.financetracker.finance_tracker_backend.repository.GoalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GoalService {
    private final GoalRepository goalRepository;

    @Autowired
    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public Goal addGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public Goal updateGoal(Long id, Goal goal) {
        Optional<Goal> existingGoal = goalRepository.findById(id);
        if (existingGoal.isPresent()) {
            Goal goalToUpdate = existingGoal.get();
            goalToUpdate.setName(goal.getName());
            goalToUpdate.setTargetAmount(goal.getTargetAmount());
            goalToUpdate.setCurrentProgress(goal.getCurrentProgress());
            goalToUpdate.setStartDate(goal.getStartDate());
            goalToUpdate.setEndDate(goal.getEndDate());
            goalToUpdate.setStatus(goal.getStatus());
            return goalRepository.save(goalToUpdate);
        } else {
            throw new IllegalArgumentException("Goal not found with id: " + id);
        }
    }

    public Goal findGoalById(Long id) {
        Optional<Goal> goal = goalRepository.findById(id);
        return goal.orElseThrow(() -> new RuntimeException("Goal not found"));
    }

    public List<Goal> findAllGoals() {
        return goalRepository.findAll();
    }

    public void deleteGoalById(Long id) {
        goalRepository.deleteById(id);
    }
}
