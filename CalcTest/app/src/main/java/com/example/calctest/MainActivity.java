package com.example.calctest;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    // Class variables
    private static String currentNumber;
    private static TextView inputHistory;
    private static TextView displayText;
    private static double previousNumber;
    private static String pendingOperation = null;

    // Variables for voice input
    TextView mTextTv;
    TextView top_value;
    ImageButton mVoiceBtn;
    private static final int RECOGNIZER_RESULT = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "0";
        displayText = findViewById(R.id.textbox);
        inputHistory = findViewById(R.id.texthistory);
        Button zeroButton = findViewById(R.id.zero);
        Button oneButton = findViewById(R.id.one);
        Button twoButton = findViewById(R.id.two);
        Button threeButton = findViewById(R.id.three);
        Button fourButton = findViewById(R.id.four);
        Button fiveButton = findViewById(R.id.five);
        Button sixButton = findViewById(R.id.six);
        Button sevenButton = findViewById(R.id.seven);
        Button eightButton = findViewById(R.id.eight);
        Button nineButton = findViewById(R.id.nine);
        Button decimalButton = findViewById(R.id.decimal);
        Button clearButton = findViewById(R.id.AC);
        Button bracketButton = findViewById(R.id.bracket);
        Button changeSignButton = findViewById(R.id.negative);
        Button divideButton = findViewById(R.id.divide);
        Button multiplyButton = findViewById(R.id.multiply);
        Button addButton = findViewById(R.id.add);
        Button subtractButton = findViewById(R.id.minus);
        Button equalsButton = findViewById(R.id.equal);


        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToString("1");
            }
        });
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToString("2");
            }
        });
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToString("3");
            }
        });
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToString("4");
            }
        });
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToString("5");
            }
        });
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToString("6");
            }
        });
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToString("7");
            }
        });
        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToString("8");
            }
        });
        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToString("9");
            }
        });
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToString("0");
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //This code executes when AC button is pressed
                System.out.println("All clear was tapped.");
            }
        });

        changeSignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Change sign was tapped.");
            }
        });
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Divide button was pressed");
            }
        });
    }
    private static void addToString(String value){
        System.out.println(value + "Was pressed");
        boolean isNumber = true;

        try{
            Double.parseDouble(value);
        }
        catch(Exception e){
            isNumber = false;
            handleNonNumber(value);

        }
        if(isNumber && !currentNumber.contains(".")) {
            if (currentNumber.equals("0")) {
                currentNumber = value;
            } else {
                currentNumber += value;
            }
            displayText.setText(currentNumber);
        }

    }
    private static void handleNonNumber(String operator){
        switch (operator){
            case "+":
                pendingOperation = "+";
            case "-":
                pendingOperation = "-";
            case "=":
                pendingOperation = "=";
            case "*":
                pendingOperation = "*";
            case "/":
                pendingOperation = "/";


        }
    }
}