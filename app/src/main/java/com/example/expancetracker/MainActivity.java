package com.example.expancetracker;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpenseViewModel expenseViewModel;
    private TextView textViewTodayTotal;
    private TextView textViewMonthTotal;
    private ExpenseListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextAmount = findViewById(R.id.editTextAmount);
        EditText editTextCategory = findViewById(R.id.editTextCategory);
        EditText editTextDescription = findViewById(R.id.editTextDescription);
        Button buttonViewMonthExpenses = findViewById(R.id.buttonViewMonthExpenses);
        Button buttonAddExpense = findViewById(R.id.buttonAddExpense);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        Button buttonShareExpenses = findViewById(R.id.buttonShareExpenses);

        textViewTodayTotal = findViewById(R.id.textViewTodayTotal);
        textViewMonthTotal = findViewById(R.id.textViewMonthTotal);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new ExpenseListAdapter(new ExpenseListAdapter.ExpenseDiff());
        recyclerView.setAdapter(adapter);

        expenseViewModel = new ViewModelProvider(this).get(ExpenseViewModel.class);
        expenseViewModel.getAllExpenses().observe(this, this::updateExpenses);

        buttonAddExpense.setOnClickListener(v -> {
            String amountStr = editTextAmount.getText().toString();
            String category = editTextCategory.getText().toString();
            String description = editTextDescription.getText().toString();

            if (!TextUtils.isEmpty(amountStr) && !TextUtils.isEmpty(category)) {
                double amount = Double.parseDouble(amountStr);
                long date = new Date().getTime();

                Expense expense = new Expense(amount, category, date, description);
                expenseViewModel.insert(expense);

                editTextAmount.setText("");
                editTextCategory.setText("");
                editTextDescription.setText("");
            }
        });

        buttonViewMonthExpenses.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MonthExpenseActivity.class);
            startActivity(intent);
        });

        buttonShareExpenses.setOnClickListener(v -> shareExpenses());
    }

    private void updateExpenses(List<Expense> expenses) {
        double todayTotal = 0;
        double monthTotal = 0;

        long now = new Date().getTime();
        Calendar calendar = Calendar.getInstance();

        // Today's date
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long startOfToday = calendar.getTimeInMillis();

        // This month's date
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        long startOfMonth = calendar.getTimeInMillis();

        for (Expense expense : expenses) {
            if (expense.getDate() >= startOfToday) {
                todayTotal += expense.getAmount();
            }
            if (expense.getDate() >= startOfMonth) {
                monthTotal += expense.getAmount();
            }
        }

        textViewTodayTotal.setText(String.format("आज : ₹%.2f", todayTotal));
        textViewMonthTotal.setText(String.format("इस महीने : ₹%.2f", monthTotal));

        // Update the RecyclerView
        adapter.submitList(expenses);
    }

    private void shareExpenses() {
        expenseViewModel.getAllExpenses().observe(this, expenses -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Expenses:\n\n");

            for (Expense expense : expenses) {
                String date = new Date(expense.getDate()).toString();
                sb.append(String.format("Date: %s\nAmount: ₹%.2f\nCategory: %s\n\n", date, expense.getAmount(), expense.getCategory()));
            }

            String expenseText = sb.toString();

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "My Expenses");
            intent.putExtra(Intent.EXTRA_TEXT, expenseText);
            startActivity(Intent.createChooser(intent, "Share via"));
        });
    }
}
