package com.example.expancetracker;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ExpenseViewModel extends AndroidViewModel {
    private final ExpenseRepository repository;
    private final LiveData<List<Expense>> allExpenses;
    private final LiveData<List<Expense>> monthExpenses;


    public ExpenseViewModel(Application application) {
        super(application);
        repository = new ExpenseRepository(application);
        allExpenses = repository.getAllExpenses();
        monthExpenses = repository.getMonthExpenses();
    }

    public LiveData<List<Expense>> getAllExpenses() {
        return allExpenses;
    }

    public void insert(Expense expense) {
        repository.insert(expense);
    }
    public LiveData<List<Expense>> getMonthExpenses() {
        return monthExpenses; // Add this method
    }




}