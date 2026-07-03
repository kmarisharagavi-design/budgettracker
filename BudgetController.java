package com.risha.budgettracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.risha.budgettracker.model.Budget;
import com.risha.budgettracker.service.BudgetService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/budget")
public class BudgetController {

    @Autowired
    private BudgetService service;

    @PostMapping
    public Budget saveBudget(
            @RequestBody Budget budget){

        return service.saveBudget(budget);

    }

    @GetMapping("/{userId}")
    public Budget getBudget(
            @PathVariable int userId){

        return service.getBudget(userId);

    }

}