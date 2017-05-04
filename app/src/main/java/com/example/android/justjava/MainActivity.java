package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceMessage = "Total = $" + calculatePrice(quantity, 4.99);
        priceMessage = priceMessage + "\nThank you!";
        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity) {
        int price = quantity * 5;
        return price;
    }
    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private double calculatePrice(int quantity, double cost) {
        double price = quantity * cost;
        return price;
    }
    /**
     * Calculates the price of the order.
     *
     *
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**This method is called when plus button is clicked: increases quantity by 1 */
int quantity = 0;

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
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}