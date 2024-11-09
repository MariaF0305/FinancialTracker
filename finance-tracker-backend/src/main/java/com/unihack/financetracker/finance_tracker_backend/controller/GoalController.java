package com.unihack.financetracker.finance_tracker_backend.controller;

import com.unihack.financetracker.finance_tracker_backend.entity.Goal;
import com.unihack.financetracker.finance_tracker_backend.service.GoalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class GoalController {
    private GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Goal>> getAllGoals() {
        List<Goal> goals = goalService.findAllGoals();
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable("id") Long id) {
        Goal goal = goalService.findGoalById(id);
        return new ResponseEntity<>(goal, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Goal> addGoal(@RequestBody Goal goal) {
        Goal newGoal = goalService.addGoal(goal);
        return new ResponseEntity<>(newGoal, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable("id") Long id, @RequestBody Goal goal) {
        Goal updateGoal = goalService.updateGoal(id, goal);
        return new ResponseEntity<>(goalService.updateGoal(id, goal), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGoal(@PathVariable("id") Long id) {
        goalService.deleteGoalById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
