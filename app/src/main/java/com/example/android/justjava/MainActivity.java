package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity = 0;
    double cost = 4.5;
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped);
        boolean yesCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateBox = (CheckBox) findViewById(R.id.chocolate);
        boolean yesChocolate = chocolateBox.isChecked();

        CheckBox cinammonBox = (CheckBox) findViewById(R.id.cinammon);
        boolean yesCinammon = cinammonBox.isChecked();

        double price = calculatePrice(quantity, cost);
        displayMessage(displaySummary("Aiden Huynh", yesCream, yesChocolate, yesCinammon, quantity, price));
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private double calculatePrice(int quantity, double cost) {
        return quantity * cost;

    }

    /**
     * Displays summary order
     *@param name
     *@param quantity
     *@param price
     *
     */

    private String displaySummary(String name, boolean topping, boolean chocolate, boolean cinammon, int quantity, double price){
        String summaryMessage = "Name: " + name
                + "\nWhipped Cream? " + topping
                + "\nChocolate? " + chocolate
                + "\nCinammon? " + cinammon
                + "\nQuantity: " + quantity
                + "\nTotal: $" + price + "\nThank you!";
        return summaryMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**This method is called when plus button is clicked: increases quantity by 1 */


    public void increment (View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**This method is called when minus button is clicked: decreases quantity by 1 */
    public void decrement (View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }





}