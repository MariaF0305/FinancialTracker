package com.unihack.financetracker.finance_tracker_backend.service;

import com.unihack.financetracker.finance_tracker_backend.entity.Transaction;
import com.unihack.financetracker.finance_tracker_backend.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Long id, Transaction transaction) {
        Optional<Transaction> existingTransaction = transactionRepository.findById(id);
        if (existingTransaction.isPresent()) {
            Transaction transactionToUpdate = existingTransaction.get();
            transactionToUpdate.setAmount(transaction.getAmount());
            transactionToUpdate.setType(transaction.getType());
            transactionToUpdate.setCategory(transaction.getCategory());
            return transactionRepository.save(transactionToUpdate);
        } else {
            throw new IllegalArgumentException("Transactioin not found with id: " + id);
        }
    }

    public Transaction findTransactionById(Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction.orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }

    public void deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
    }

}
