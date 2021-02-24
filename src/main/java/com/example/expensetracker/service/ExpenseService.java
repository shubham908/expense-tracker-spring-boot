package com.example.expensetracker.service;

import com.example.expensetracker.dto.ExpenseDTO;
import com.example.expensetracker.entity.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public ExpenseDTO listAllExpensesByUser(Integer userId) {
        List<Expense> expenseList =  expenseRepository.findByUser_Id(userId);
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setUserId(userId);
        expenseDTO.setUserName(expenseList.get(0).getUser().getName());

        List<Map<String, Object>> list = new ArrayList<>();

        for(Expense expense: expenseList) {
            Map<String, Object> map = new HashMap<>();
            map.put("category", expense.getCategory());
            map.put("description", expense.getDescription());
            map.put("amount", expense.getAmount());
            map.put("expense-date", expense.getExpenseDate());

            list.add(map);
        }

        expenseDTO.setList(list);

        return expenseDTO;
    }

    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }
}
