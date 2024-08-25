package com.example.expancetracker;
public class ExpenseListItem {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_EXPENSE = 1;

    private int type;
    private String header;
    private Expense expense;

    public ExpenseListItem(int type, String header) {
        this.type = type;
        this.header = header;
    }

    public ExpenseListItem(int type, Expense expense) {
        this.type = type;
        this.expense = expense;
    }

    public int getType() {
        return type;
    }

    public String getHeader() {
        return header;
    }

    public Expense getExpense() {
        return expense;
    }
}
