package edu.miracosta.cs134.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    //Member vaariables to format as currency or percent(NUmberFormat)
    NumberFormat currency = number

    // Member variables for each component used in the app
    private EditText amountEditText;
    private TextView percentTextView;
    private TextView tipTextView;
    private TextView totalTextView;
    private SeekBar percentSeekBar;

    // Member variable for our model
    private Bill currentBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all member variables in onCreate
        amountEditText = findViewById(R.id.amountEditText);
        percentTextView = findViewById(R.id.percentTextView);
        tipTextView = findViewById(R.id.tipTextView);
        totalTextView = findViewById(R.id.totalTextView);
        percentSeekBar = findViewById(R.id.percentSeekBar);

        //Initialize our model
        currentBill = new Bill();
        // Set the tip percent to match the seek bar
        currentBill.setTipPercent(percentSeekBar.getProgress() / 100.0);
        // Connect code to the event conProgressChanged for seekBar
        percentSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Update our model as well
                currentBill.setTipPercent(progress / 100.0);
                //Change the label of the tip percent
                percentTextView.setText(percent.format(currentBill.getTipPercent());
                tipTextView.setText(currency.format(currentBill.getTipAmount()));
                totalTextView.setText(currency.format(currentBill.getTipAmount()));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Does nothing

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Does nothing

            }
        });

                //connect code to the event onTexrChanged for EditText
        amountEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //update our model (currentBill)
                currentBill.setAmount(Double.parseDouble(amountEditText.getText().toString()));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
