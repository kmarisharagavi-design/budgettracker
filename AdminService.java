package com.risha.budgettracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.risha.budgettracker.model.User;
import com.risha.budgettracker.repository.UserRepository;
import com.risha.budgettracker.repository.IncomeRepository;
import com.risha.budgettracker.repository.ExpenseRepository;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private IncomeRepository incomeRepo;

    @Autowired
    private ExpenseRepository expenseRepo;

    public long totalUsers(){

        return userRepo.count();

    }

    public double totalIncome(){

        return incomeRepo.getTotalIncome();

    }

    public double totalExpense(){

        return expenseRepo.getTotalExpense();

    }

    public long totalTransactions(){

        return incomeRepo.count() + expenseRepo.count();

    }
    public List<User> getAllUsers(){

    return userRepo.findAll();

}

}