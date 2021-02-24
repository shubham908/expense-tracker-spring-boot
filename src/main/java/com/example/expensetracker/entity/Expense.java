package com.example.expensetracker.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "expense", schema="public")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EXPENSE_ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @Column(name = "CREATED_ON", nullable = false)
    private Date expenseDate;

    public Expense() {
    }

    public Expense(Integer id, User user, String category, String description, BigDecimal amount, Date expenseDate) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.expenseDate = expenseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", user=" + user +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", expenseDate=" + expenseDate +
                '}';
    }
}
