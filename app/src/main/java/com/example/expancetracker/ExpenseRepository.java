package com.example.expancetracker;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.Calendar;
import java.util.List;

public class ExpenseRepository {
    private final ExpenseDao expenseDao;
    private final ExpenseDatabase expenseDatabase;

    // Constructor to initialize the repository with the application context
    public ExpenseRepository(Application application) {
        // Initialize the database and DAO
        expenseDatabase = ExpenseDatabase.getDatabase(application);
        expenseDao = expenseDatabase.expenseDao();
    }

    // Retrieve all expenses
    public LiveData<List<Expense>> getAllExpenses() {
        return expenseDao.getAllExpenses();
    }
    public LiveData<List<Expense>> getExpensesAfter(long startDate) {
        return expenseDao.getExpensesAfter(startDate);
    }
    public void insert(Expense expense) {
        ExpenseDatabase.databaseWriteExecutor.execute(() -> expenseDao.insert(expense));
    }

    // Calculate total expenses for today
    public LiveData<Double> getTodayTotal() {
        Calendar calendar = Calendar.getInstance();
        long startOfDay = calendar.getTimeInMillis();
        return Transformations.map(expenseDao.getExpensesAfter(startOfDay), expenses -> {
            double total = 0;
            for (Expense expense : expenses) {
                total += expense.getAmount();
            }
            return total;
        });
    }

    // Calculate total expenses for the current month
    public LiveData<Double> getMonthTotal() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        long startOfMonth = calendar.getTimeInMillis();
        return Transformations.map(expenseDao.getExpensesAfter(startOfMonth), expenses -> {
            double total = 0;
            for (Expense expense : expenses) {
                total += expense.getAmount();
            }
            return total;
        });
    }


    public LiveData<List<Expense>> getMonthExpenses() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        long startOfMonth = calendar.getTimeInMillis();
        return expenseDao.getExpensesAfter(startOfMonth);
    }




}
