package com.example.expensetracker.dto;

import com.example.expensetracker.entity.Expense;

import java.util.List;
import java.util.Map;

public class ExpenseDTO {

    private Integer userId;
    private String userName;
    private List<Map<String, Object>> list;

    public ExpenseDTO() {
    }

    public ExpenseDTO(Integer userId, String userName, List<Map<String, Object>> list) {
        this.userId = userId;
        this.userName = userName;
        this.list = list;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Map<String, Object>> getList() {
        return list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ExpenseDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", list=" + list +
                '}';
    }
}
