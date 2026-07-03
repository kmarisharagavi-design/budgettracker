package com.risha.budgettracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risha.budgettracker.model.Income;
import com.risha.budgettracker.repository.IncomeRepository;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository repo;

    // Save Income
    public Income saveIncome(Income income) {
        return repo.save(income);
    }

    // Get All Income
    public List<Income> getAllIncome() {
        return repo.findAll();
    }

    // Get Income By User
    public List<Income> getIncomeByUser(int userId) {
        return repo.findByUserId(userId);
    }

    // Total Income By User
    public double getTotalIncome(int userId) {
        return repo.getTotalIncomeByUser(userId);
    }

    // Update Income
    public Income updateIncome(int id, Income income) {

        Income oldIncome = repo.findById(id).orElse(null);

        if (oldIncome != null) {

            oldIncome.setAmount(income.getAmount());
            oldIncome.setSource(income.getSource());
            oldIncome.setIncomeDate(income.getIncomeDate());
            oldIncome.setUser(income.getUser());

            return repo.save(oldIncome);
        }

        return null;
    }

    // Delete Income
    public void deleteIncome(int id) {
        repo.deleteById(id);
    }

    // Admin View All Income
    public List<Income> getAllIncomeForAdmin() {
        return repo.findAll();
    }

    // Admin Total Income
    public double getAdminTotalIncome() {
        return repo.getTotalIncome();
    }
}