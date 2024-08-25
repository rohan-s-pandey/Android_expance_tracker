package com.example.expancetracker;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Calendar;

public class MonthExpenseActivity extends AppCompatActivity {
    private ExpenseViewModel expenseViewModel;
    private MonthExpenseAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_expense);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMonth);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MonthExpenseAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        expenseViewModel = new ViewModelProvider(this).get(ExpenseViewModel.class);
        expenseViewModel.getAllExpenses().observe(this, this::updateMonthExpenses);
    }

    private void updateMonthExpenses(List<Expense> expenses) {
        List<MonthExpense> monthExpenses = calculateMonthExpenses(expenses);
        adapter = new MonthExpenseAdapter(monthExpenses);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewMonth);
        recyclerView.setAdapter(adapter);
    }

    private List<MonthExpense> calculateMonthExpenses(List<Expense> expenses) {
        Map<String, Double> monthTotals = new TreeMap<>();
        Calendar calendar = Calendar.getInstance();

        for (Expense expense : expenses) {
            calendar.setTimeInMillis(expense.getDate());
            String monthYear = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, getResources().getConfiguration().locale)
                    + " " + calendar.get(Calendar.YEAR);

            monthTotals.put(monthYear, monthTotals.getOrDefault(monthYear, 0.0) + expense.getAmount());
        }

        List<MonthExpense> monthExpenseList = new ArrayList<>();
        for (Map.Entry<String, Double> entry : monthTotals.entrySet()) {
            monthExpenseList.add(new MonthExpense(entry.getKey(), entry.getValue()));
        }

        return monthExpenseList;
    }
}
