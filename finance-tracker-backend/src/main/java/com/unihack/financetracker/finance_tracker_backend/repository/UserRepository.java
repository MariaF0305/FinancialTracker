package com.unihack.financetracker.finance_tracker_backend.repository;

import com.unihack.financetracker.finance_tracker_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
