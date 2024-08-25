package com.example.expancetracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ExpenseListAdapter extends ListAdapter<Expense, ExpenseListAdapter.ExpenseViewHolder> {

    protected ExpenseListAdapter(@NonNull DiffUtil.ItemCallback<Expense> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        Expense current = getItem(position);
        holder.bind(current.getAmount(), current.getCategory(), current.getDescription(), current.getDate());
    }

    static class ExpenseViewHolder extends RecyclerView.ViewHolder {
        private final TextView expenseItemView;

        ExpenseViewHolder(View itemView) {
            super(itemView);
            expenseItemView = itemView.findViewById(R.id.textView);
        }

        void bind(double amount, String category, String description, long date) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            String dateString = sdf.format(new Date(date));
            expenseItemView.setText("Amount: " + amount + "\nCategory: " + category + "\nDescription: " + description + "\nDate: " + dateString);
        }
    }

    public static class ExpenseDiff extends DiffUtil.ItemCallback<Expense> {
        @Override
        public boolean areItemsTheSame(@NonNull Expense oldItem, @NonNull Expense newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Expense oldItem, @NonNull Expense newItem) {
            return oldItem.equals(newItem);
        }
    }
}
