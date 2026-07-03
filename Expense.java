package com.risha.budgettracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class Expense {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private double amount;
private String category;
private String description;
 private LocalDate expenseDate;
@ManyToOne
@JoinColumn(name = "user_id")
private User user;

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public double getAmount() {
    return amount;
}

public void setAmount(double amount) {
    this.amount = amount;
}

public String getCategory() {
    return category;
}

public void setCategory(String category) {
    this.category = category;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

 public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }
public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}


}
