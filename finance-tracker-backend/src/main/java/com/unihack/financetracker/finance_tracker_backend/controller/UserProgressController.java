package com.unihack.financetracker.finance_tracker_backend.controller;

import com.unihack.financetracker.finance_tracker_backend.entity.UserProgress;
import com.unihack.financetracker.finance_tracker_backend.service.UserProgressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/userprogress")
public class UserProgressController {
    private final UserProgressService userProgressService;

    public UserProgressController(UserProgressService userProgressService) {
        this.userProgressService = userProgressService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Optional<UserProgress>> getUserProgressByUserId(@PathVariable Long userId) {
        Optional<UserProgress> progressList = userProgressService.getUserProgressById(userId);
        return ResponseEntity.ok(progressList);
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<UserProgress> addUserProgress(@PathVariable Long userId,
                                                        @RequestBody UserProgress userProgress) {
        UserProgress savedProgress = userProgressService.addUserProgress(userProgress, userId);
        return ResponseEntity.ok(savedProgress);
    }
}
