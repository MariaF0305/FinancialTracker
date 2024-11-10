package com.unihack.financetracker.finance_tracker_backend.controller;

import com.unihack.financetracker.finance_tracker_backend.entity.Leaderboard;
import com.unihack.financetracker.finance_tracker_backend.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/leaderboard")
public class LeaderboardController {
    private final LeaderboardService leaderboardService;

    @Autowired
    public LeaderboardController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Leaderboard> getLeaderboardEntryById(@PathVariable Long id) {
        Leaderboard entry = leaderboardService.getLeaderboardEntryById(id);
        return ResponseEntity.ok(entry);
    }

    @PostMapping("/add")
    public ResponseEntity<Leaderboard> addLeaderboardEntry(@RequestBody Leaderboard leaderboard) {
        Leaderboard createdEntry = leaderboardService.addLeaderboard(leaderboard);
        return ResponseEntity.ok(createdEntry);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Leaderboard> updateLeaderboardEntry(@PathVariable Long id, @RequestBody Leaderboard updatedEntry) {
        Leaderboard updated = leaderboardService.updateLeaderboardEntry(id, updatedEntry);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLeaderboardEntry(@PathVariable Long id) {
        leaderboardService.deleteLeaderboardEntry(id);
        return ResponseEntity.noContent().build();
    }
}
