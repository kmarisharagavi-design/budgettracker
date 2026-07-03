package com.risha.budgettracker.service;

import java.util.List;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risha.budgettracker.model.Expense;
import com.risha.budgettracker.repository.ExpenseRepository;

@Service
public class ExpenseService {


@Autowired
private ExpenseRepository repo;

// Create
public Expense saveExpense(Expense expense) {
    return repo.save(expense);
}

// Read All
public List<Expense> getAllExpenses() {
    return repo.findAll();
}

// Read User Expenses
public List<Expense> getExpensesByUser(int userId) {
    return repo.findByUserId(userId);
}

// Total Expense
public double getTotalExpenseByUser(int userId){
    return repo.getTotalExpenseByUser(userId);
}
// Update
public Expense updateExpense(int id, Expense expense) {

    Expense oldExpense = repo.findById(id).orElse(null);

    if (oldExpense != null) {

        oldExpense.setAmount(expense.getAmount());
        oldExpense.setCategory(expense.getCategory());
        oldExpense.setDescription(expense.getDescription());

        return repo.save(oldExpense);
    }

    return null;
}

// Delete
public void deleteExpense(int id) {
    repo.deleteById(id);
}
public double getTodayExpense(int userId){

    return repo.getTodayExpense(
            userId,
            LocalDate.now()
    );
}
public List<Expense> getRecentExpenses(int userId){
    return repo.findTop5ByUserIdOrderByExpenseDateDescIdDesc(userId);
}
public List<Object[]> getExpenseByCategory(int userId){
    return repo.getExpenseByCategory(userId);
}
public List<Expense> getMonthlyExpenses(
        int userId,
        int month,
        int year){

    return repo.getMonthlyExpenses(userId,month,year);

}
public List<Expense> getAllExpensesForAdmin(){

    return repo.findAll();

}

}
