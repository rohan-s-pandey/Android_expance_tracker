package com.example.expancetracker;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "expenses")
public class Expense {

    @PrimaryKey(autoGenerate = true)
    private int id; // Unique identifier for each expense

    private double amount;
    private String category;
    private long date;
    private String description;

    // Constructor
    public Expense(double amount, String category, long date, String description) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id (Room will use this to set the id after insertion)
    public void setId(int id) {
        this.id = id;
    }

    // Getter for amount
    public double getAmount() {
        return amount;
    }

    // Setter for amount
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Getter for category
    public String getCategory() {
        return category;
    }

    // Setter for category
    public void setCategory(String category) {
        this.category = category;
    }

    // Getter for date
    public long getDate() {
        return date;
    }

    // Setter for date
    public void setDate(long date) {
        this.date = date;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }
}
