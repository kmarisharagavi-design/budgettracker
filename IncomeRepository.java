package com.risha.budgettracker.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.risha.budgettracker.model.Income;

public interface IncomeRepository
extends JpaRepository<Income,Integer>{

    List<Income> findByUserId(int userId);

    @Query("SELECT COALESCE(SUM(i.amount),0) FROM Income i WHERE i.user.id=?1")
    double getTotalIncomeByUser(int userId);
    @Query("SELECT COALESCE(SUM(i.amount),0) FROM Income i")
double getTotalIncome();
}