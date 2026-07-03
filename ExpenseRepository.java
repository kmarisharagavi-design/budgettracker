package com.risha.budgettracker.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.risha.budgettracker.model.Expense;

public interface ExpenseRepository
        extends JpaRepository<Expense,Integer>{

    // User Expenses
    List<Expense> findByUserId(int userId);

    // Recent 5 Expenses
    List<Expense> findTop5ByUserIdOrderByExpenseDateDescIdDesc(int userId);

    // Total Expense
    @Query("SELECT COALESCE(SUM(e.amount),0) FROM Expense e WHERE e.user.id=?1")
    double getTotalExpenseByUser(int userId);

    // Today's Expense
    @Query("""
        SELECT COALESCE(SUM(e.amount),0)
        FROM Expense e
        WHERE e.user.id=?1
        AND e.expenseDate=?2
    """)
    double getTodayExpense(int userId, LocalDate date);
    @Query("""
SELECT e.category, SUM(e.amount)
FROM Expense e
WHERE e.user.id = ?1
GROUP BY e.category
""")
List<Object[]> getExpenseByCategory(int userId);


@Query("""
SELECT e
FROM Expense e
WHERE e.user.id=?1
AND MONTH(e.expenseDate)=?2
AND YEAR(e.expenseDate)=?3
""")
List<Expense> getMonthlyExpenses(int userId,int month,int year);
@Query("SELECT COALESCE(SUM(e.amount),0) FROM Expense e")
double getTotalExpense();
        }