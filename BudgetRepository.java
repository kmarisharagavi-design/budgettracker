package com.risha.budgettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.risha.budgettracker.model.Budget;

public interface BudgetRepository
        extends JpaRepository<Budget,Integer>{

    Budget findByUserId(int userId);

}