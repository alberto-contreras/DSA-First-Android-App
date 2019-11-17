package com.example.myfirstapplication_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Asign a variable to each button
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button add;
    private Button sub;
    private Button div;
    private Button mul;
    private Button equ;
    private Button cln;
    private TextView info;
    private TextView result;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = 0;
    private double val1 = Double.NaN;//Define the variable where it will be save the value to operate
    private double val2 = Double.NaN;//We define it as NaNumber to don't have problems with the divisions
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpUIView(); //Function that we have define to assign the value to each variable

        zero.setOnClickListener(new View.OnClickListener() { //What happen when we click the button zero
            @Override
            public void onClick(View v) { //When we click we set in the text view info the value 0
                info.setText(info.getText().toString() + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() { //What happen when we click the button one
            @Override
            public void onClick(View v) { //When we click we set in the text view info the value 1
                info.setText(info.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() { //What happen when we click the button two
            @Override
            public void onClick(View v) { //When we click we set in the text view info the value 2
                info.setText(info.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() { //What happen when we click the button three
            @Override
            public void onClick(View v) { //When we click we set in the text view info the value 3
                info.setText(info.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "9");
            }
        });
        add.setOnClickListener(new View.OnClickListener() { //Perform the operation
            @Override
            public void onClick(View v) {
                compute(); //Function that calculate or assign the value if val1 or val2 don't have
                ACTION = ADDITION; // Value of the action
                result.setText(String.valueOf(val1) + "+"); // in the tv we assign the full operation
                info.setText(null);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() { //Perform the operation
            @Override
            public void onClick(View v) {
                compute(); //Function that calculate or assign the value if val1 or val2 don't have
                ACTION = SUBTRACTION;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);
            }
        });
        div.setOnClickListener(new View.OnClickListener() { //Perform the operation
            @Override
            public void onClick(View v) {
                compute(); //Function that calculate or assign the value if val1 or val2 don't have
                ACTION = DIVISION;
                result.setText(String.valueOf(val1) + "/");
                info.setText(null);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() { //Perform the operation
            @Override
            public void onClick(View v) {
                compute(); //Function that calculate or assign the value if val1 or val2 don't have
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(val1) + "*");
                info.setText(null);
            }
        });
        equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQU;
                result.setText(String.valueOf(result.getText().toString() + String.valueOf(val2) + "="+String.valueOf(val1)));
                //We will have tvres the full operatio ex. 5+5=10
                info.setText(null); //Clear info
            }
        });
        cln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length()>0){ //IF IN THE INFO WE HAVE TEXT
                    CharSequence name = info.getText().toString();//WE GET THE TEXT
                    info.setText(name.subSequence(0,name.length()-1));//WE CLEAN THE LAST VALUE THAT CAN BE THE OPERATION OR NUMBER
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }

            }
        });




    }
    //Create a function to setup each variable with his button
    private void setUpUIView(){
        zero = (Button)findViewById(R.id.btn0);
        one = (Button)findViewById(R.id.btn1); //res.id.btn
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        add = (Button)findViewById(R.id.btnadd);
        sub = (Button)findViewById(R.id.btnsub);
        div = (Button)findViewById(R.id.btndiv);
        mul = (Button)findViewById(R.id.btnmult);
        cln = (Button)findViewById(R.id.btncl);
        info = (TextView)findViewById(R.id.tvControl);
        result = (TextView)findViewById(R.id.tvResult);

    }
    private void compute(){ //Function that calculates
        if(!Double.isNaN(val1)) {//if val1 is have a value we assing to val2 the actual number that user have press
            val2 = Double.parseDouble(info.getText().toString());
            switch (ACTION) { //Once both val1 and val2 have a value the operations are perform
                case (ADDITION):
                    val1 = val1 + val2;
                    break;
                case (SUBTRACTION):
                    val1 = val1 - val2;
                    break;
                case (DIVISION):
                    val1 = val1 / val2;
                    break;
                case (MULTIPLICATION):
                    val1 = val1 * val2;
                    break;
                case (EQU):
                    break;
            }
        }
        else { //Asign the value to val1
            val1 = Double.parseDouble(info.getText().toString());
        }






    }
}
