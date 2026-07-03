package com.risha.budgettracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.risha.budgettracker.model.Income;
import com.risha.budgettracker.service.IncomeService;
import com.risha.budgettracker.service.AdminService;
import java.util.List;
import com.risha.budgettracker.model.User;
import com.risha.budgettracker.model.Expense;
import com.risha.budgettracker.service.ExpenseService;
@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="*")
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping("/users/count")
    public long totalUsers(){

        return service.totalUsers();

    }
@Autowired
private IncomeService incomeService;

@GetMapping("/income")
public List<Income> getAllIncome(){

    return incomeService.getAllIncomeForAdmin();

}
    @GetMapping("/income/total")
    public double totalIncome(){

        return service.totalIncome();

    }

    @GetMapping("/expense/total")
    public double totalExpense(){

        return service.totalExpense();

    }

    @GetMapping("/transactions")
    public long totalTransactions(){

        return service.totalTransactions();

    }
    @GetMapping("/users")
public List<User> getAllUsers(){

    return service.getAllUsers();

}
@Autowired
private ExpenseService expenseService;

@GetMapping("/expenses")
public List<Expense> getAllExpenses(){

    return expenseService.getAllExpensesForAdmin();

}

}