package com.risha.budgettracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risha.budgettracker.model.Budget;
import com.risha.budgettracker.repository.BudgetRepository;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository repo;

    public Budget saveBudget(Budget budget){

        return repo.save(budget);

    }

    public Budget getBudget(int userId){

        return repo.findByUserId(userId);

    }

}