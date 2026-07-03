package com.risha.budgettracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.risha.budgettracker.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins="*")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/report/{userId}")
    public void downloadReport(
            @PathVariable int userId,
            HttpServletResponse response) throws Exception{

        response.setContentType("application/pdf");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=BudgetReport.pdf");

        reportService.generatePdf(userId,response);
    }
}