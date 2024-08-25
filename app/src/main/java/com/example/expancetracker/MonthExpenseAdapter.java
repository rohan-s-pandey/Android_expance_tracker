package com.example.expancetracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MonthExpenseAdapter extends RecyclerView.Adapter<MonthExpenseAdapter.MonthExpenseViewHolder> {

    private final List<MonthExpense> monthExpenseList;

    public MonthExpenseAdapter(List<MonthExpense> monthExpenseList) {
        this.monthExpenseList = monthExpenseList;
    }

    @NonNull
    @Override
    public MonthExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_month_expense, parent, false);
        return new MonthExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonthExpenseViewHolder holder, int position) {
        MonthExpense current = monthExpenseList.get(position);
        holder.bind(current.getMonthName(), current.getTotalAmount());
    }

    @Override
    public int getItemCount() {
        return monthExpenseList.size();
    }

    static class MonthExpenseViewHolder extends RecyclerView.ViewHolder {
        private final TextView monthTextView;
        private final TextView totalTextView;

        MonthExpenseViewHolder(View itemView) {
            super(itemView);
            monthTextView = itemView.findViewById(R.id.textViewMonth);
            totalTextView = itemView.findViewById(R.id.textViewTotal);
        }

        void bind(String monthName, double totalAmount) {
            monthTextView.setText(monthName);
            totalTextView.setText(String.format("₹%.2f", totalAmount));
        }
    }
}
