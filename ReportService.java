package com.risha.budgettracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.risha.budgettracker.model.Expense;
import com.risha.budgettracker.repository.ExpenseRepository;
import com.risha.budgettracker.repository.IncomeRepository;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportService {

    @Autowired
    private ExpenseRepository expenseRepo;

    @Autowired
    private IncomeRepository incomeRepo;

    public void generatePdf(
            int userId,
            HttpServletResponse response) throws Exception{

        Document document = new Document();

        PdfWriter.getInstance(
                document,
                response.getOutputStream());

        document.open();

        document.add(new Paragraph("BUDGET TRACKER REPORT"));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("------------------------------"));

        double income =
                incomeRepo.getTotalIncomeByUser(userId);

        double expense =
                expenseRepo.getTotalExpenseByUser(userId);

        document.add(new Paragraph("Total Income : ₹"+income));
        document.add(new Paragraph("Total Expense : ₹"+expense));
        document.add(new Paragraph("Balance : ₹"+(income-expense)));

        document.add(new Paragraph(" "));
        document.add(new Paragraph("Expense Details"));

        PdfPTable table = new PdfPTable(4);

        table.addCell("Date");
        table.addCell("Category");
        table.addCell("Amount");
        table.addCell("Description");

        List<Expense> expenses =
                expenseRepo.findByUserId(userId);

        for(Expense e:expenses){

            table.addCell(String.valueOf(e.getExpenseDate()));
            table.addCell(e.getCategory());
            table.addCell(String.valueOf(e.getAmount()));
            table.addCell(e.getDescription());

        }

        document.add(table);

        document.close();
    }
}