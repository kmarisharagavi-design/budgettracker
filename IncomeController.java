package com.risha.budgettracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.risha.budgettracker.model.Income;
import com.risha.budgettracker.service.IncomeService;

@RestController
@RequestMapping("/income")
@CrossOrigin(origins="*")
public class IncomeController {

    @Autowired
    private IncomeService service;

    @PostMapping
    public Income addIncome(@RequestBody Income income){

        return service.saveIncome(income);

    }

    @GetMapping
    public List<Income> getAllIncome(){

        return service.getAllIncome();

    }

    @GetMapping("/user/{userId}")
    public List<Income> getIncomeByUser(
            @PathVariable int userId){

        return service.getIncomeByUser(userId);

    }

    @GetMapping("/total/{userId}")
    public double getTotalIncome(
            @PathVariable int userId){

        return service.getTotalIncome(userId);

    }

    @PutMapping("/{id}")
    public Income updateIncome(
            @PathVariable int id,
            @RequestBody Income income){

        return service.updateIncome(id,income);

    }

    @DeleteMapping("/{id}")
    public String deleteIncome(
            @PathVariable int id){

        service.deleteIncome(id);

        return "Income Deleted Successfully";
    }

}