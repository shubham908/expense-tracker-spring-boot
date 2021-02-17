package com.example.expensetracker.controller;

import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/expense")
@RestController
public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @RequestMapping(value = "/list-expense/{userId}", method = RequestMethod.GET)
    public ResponseEntity<ExpenseDTO> listExpenseByUser(@PathVariable Integer userId) {
        ExpenseDTO expenseDTO = expenseService.listAllExpensesByUser(userId);
        return new ResponseEntity<>(expenseDTO, HttpStatus.OK);
    }
}
