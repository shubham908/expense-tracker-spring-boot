package com.example.expensetracker.controller;

import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/expense")
@RestController
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @RequestMapping(value = "/list-expense/{userId}", method = RequestMethod.GET)
    public ResponseEntity<ExpenseDTO> listExpenseByUser(@PathVariable Integer userId) {
        ExpenseDTO expenseDTO = expenseService.listAllExpensesByUser(userId);
        return new ResponseEntity<>(expenseDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/add-expense", method = RequestMethod.POST)
    public ResponseEntity<String> addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return new ResponseEntity<>("Expense Added", HttpStatus.OK);
    }
}
