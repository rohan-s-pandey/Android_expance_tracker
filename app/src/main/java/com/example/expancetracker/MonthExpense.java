package com.example.expancetracker;

public class MonthExpense {
    private final String monthName;
    private final double totalAmount;

    public MonthExpense(String monthName, double totalAmount) {
        this.monthName = monthName;
        this.totalAmount = totalAmount;
    }

    public String getMonthName() {
        return monthName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
