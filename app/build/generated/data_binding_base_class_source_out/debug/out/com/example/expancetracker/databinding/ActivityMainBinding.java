// Generated by view binder compiler. Do not edit!
package com.example.expancetracker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.expancetracker.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final MaterialButton buttonAddExpense;

  @NonNull
  public final MaterialButton buttonShareExpenses;

  @NonNull
  public final MaterialButton buttonViewMonthExpenses;

  @NonNull
  public final ImageView circularImage;

  @NonNull
  public final TextInputEditText editTextAmount;

  @NonNull
  public final TextInputEditText editTextCategory;

  @NonNull
  public final TextInputEditText editTextDescription;

  @NonNull
  public final TextView imageDescription;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final TextView textViewMonthTotal;

  @NonNull
  public final TextView textViewTodayTotal;

  private ActivityMainBinding(@NonNull LinearLayout rootView,
      @NonNull MaterialButton buttonAddExpense, @NonNull MaterialButton buttonShareExpenses,
      @NonNull MaterialButton buttonViewMonthExpenses, @NonNull ImageView circularImage,
      @NonNull TextInputEditText editTextAmount, @NonNull TextInputEditText editTextCategory,
      @NonNull TextInputEditText editTextDescription, @NonNull TextView imageDescription,
      @NonNull RecyclerView recyclerView, @NonNull TextView textViewMonthTotal,
      @NonNull TextView textViewTodayTotal) {
    this.rootView = rootView;
    this.buttonAddExpense = buttonAddExpense;
    this.buttonShareExpenses = buttonShareExpenses;
    this.buttonViewMonthExpenses = buttonViewMonthExpenses;
    this.circularImage = circularImage;
    this.editTextAmount = editTextAmount;
    this.editTextCategory = editTextCategory;
    this.editTextDescription = editTextDescription;
    this.imageDescription = imageDescription;
    this.recyclerView = recyclerView;
    this.textViewMonthTotal = textViewMonthTotal;
    this.textViewTodayTotal = textViewTodayTotal;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonAddExpense;
      MaterialButton buttonAddExpense = ViewBindings.findChildViewById(rootView, id);
      if (buttonAddExpense == null) {
        break missingId;
      }

      id = R.id.buttonShareExpenses;
      MaterialButton buttonShareExpenses = ViewBindings.findChildViewById(rootView, id);
      if (buttonShareExpenses == null) {
        break missingId;
      }

      id = R.id.buttonViewMonthExpenses;
      MaterialButton buttonViewMonthExpenses = ViewBindings.findChildViewById(rootView, id);
      if (buttonViewMonthExpenses == null) {
        break missingId;
      }

      id = R.id.circularImage;
      ImageView circularImage = ViewBindings.findChildViewById(rootView, id);
      if (circularImage == null) {
        break missingId;
      }

      id = R.id.editTextAmount;
      TextInputEditText editTextAmount = ViewBindings.findChildViewById(rootView, id);
      if (editTextAmount == null) {
        break missingId;
      }

      id = R.id.editTextCategory;
      TextInputEditText editTextCategory = ViewBindings.findChildViewById(rootView, id);
      if (editTextCategory == null) {
        break missingId;
      }

      id = R.id.editTextDescription;
      TextInputEditText editTextDescription = ViewBindings.findChildViewById(rootView, id);
      if (editTextDescription == null) {
        break missingId;
      }

      id = R.id.imageDescription;
      TextView imageDescription = ViewBindings.findChildViewById(rootView, id);
      if (imageDescription == null) {
        break missingId;
      }

      id = R.id.recyclerView;
      RecyclerView recyclerView = ViewBindings.findChildViewById(rootView, id);
      if (recyclerView == null) {
        break missingId;
      }

      id = R.id.textViewMonthTotal;
      TextView textViewMonthTotal = ViewBindings.findChildViewById(rootView, id);
      if (textViewMonthTotal == null) {
        break missingId;
      }

      id = R.id.textViewTodayTotal;
      TextView textViewTodayTotal = ViewBindings.findChildViewById(rootView, id);
      if (textViewTodayTotal == null) {
        break missingId;
      }

      return new ActivityMainBinding((LinearLayout) rootView, buttonAddExpense, buttonShareExpenses,
          buttonViewMonthExpenses, circularImage, editTextAmount, editTextCategory,
          editTextDescription, imageDescription, recyclerView, textViewMonthTotal,
          textViewTodayTotal);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
