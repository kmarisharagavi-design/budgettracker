package com.risha.budgettracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.risha.budgettracker.model.Expense;
import com.risha.budgettracker.service.ExpenseService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    // Create
    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return service.saveExpense(expense);
    }

    // Read All
    @GetMapping
    public List<Expense> getAllExpenses() {
        return service.getAllExpenses();
    }

    // Read User Expenses
    @GetMapping("/user/{userId}")
    public List<Expense> getExpensesByUser(
            @PathVariable int userId) {

        return service.getExpensesByUser(userId);
    }

    // Total Expense
    @GetMapping("/total/{userId}")
    public double getTotalExpenseByUser(
            @PathVariable int userId) {

        return service.getTotalExpenseByUser(userId);
    }

    // Today's Expense
    @GetMapping("/today/{userId}")
    public double getTodayExpense(
            @PathVariable int userId) {

        return service.getTodayExpense(userId);
    }
    @GetMapping("/recent/{userId}")
public List<Expense> getRecentExpenses(
        @PathVariable int userId){

    return service.getRecentExpenses(userId);
}
@GetMapping("/category/{userId}")
public List<Object[]> getExpenseByCategory(
        @PathVariable int userId){

    return service.getExpenseByCategory(userId);
}
@GetMapping("/report/{userId}/{month}/{year}")
public List<Expense> getMonthlyReport(

        @PathVariable int userId,
        @PathVariable int month,
        @PathVariable int year){

    return service.getMonthlyExpenses(
            userId,
            month,
            year
    );
}

    // Update
    @PutMapping("/{id}")
    public Expense updateExpense(
            @PathVariable int id,
            @RequestBody Expense expense) {

        return service.updateExpense(id, expense);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable int id) {

        service.deleteExpense(id);

        return "Expense Deleted Successfully";
    }

}