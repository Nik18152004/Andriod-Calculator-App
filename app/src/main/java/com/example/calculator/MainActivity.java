package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    double firstNum;
    double secondNum;
    String operation;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button AC = findViewById(R.id.Ac);
        Button OFF = findViewById(R.id.on);
        Button DEL = findViewById(R.id.del);
        Button plus = findViewById(R.id.add);
        Button sub= findViewById(R.id.sub);
        Button div = findViewById(R.id.div);
        Button mul = findViewById(R.id.mul);
        Button point  = findViewById(R.id.dot);
        Button equal = findViewById(R.id.equal);
        Button square= findViewById(R.id.sqrt);



        Button num0 = findViewById(R.id.num0);
        Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);
        Button num3 = findViewById(R.id.num3);
        Button num4 = findViewById(R.id.num4);
        Button num5 = findViewById(R.id.num5);
        Button num6 = findViewById(R.id.num6);
        Button num7 = findViewById(R.id.num7);
        Button num8 = findViewById(R.id.num8);
        Button num9 = findViewById(R.id.num9);

        TextView Screen = findViewById(R.id.text);
        TextView Screen2 = findViewById(R.id.text1);

        AC.setOnClickListener(view -> {
            firstNum = 0;
            Screen.setText("0");
            Screen2.setText(null);
        });

        ArrayList<Button> num = new ArrayList<>();
        num.add(num0);
        num.add(num1);
        num.add(num2);
        num.add(num3);
        num.add(num4);
        num.add(num5);
        num.add(num6);
        num.add(num7);
        num.add(num8);
        num.add(num9);

        for (Button b : num)  {
            b.setOnClickListener(view -> {
                if (!Screen.getText().toString().equals("0")) {
                    Screen.setText(Screen.getText().toString() + b.getText().toString());
                } else {
                    Screen.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> opers = new ArrayList<>();
        opers.add(plus);
        opers.add(sub);
        opers.add(div);
        opers.add(mul);

        for (Button b : opers) {
            b.setOnClickListener(view -> {
                firstNum = Double.parseDouble(Screen.getText().toString());

                operation = b.getText().toString();
                Screen.setText(firstNum + b.getText().toString());
                Screen.setText("");
            });
        }

        OFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        DEL.setOnClickListener(view -> {
            String nums = Screen.getText().toString();
            if(nums.length()>1) {
                Screen.setText(nums.substring(0, nums.length() - 1));
            } else if (nums.length() == 1 && !nums.equals("0"))  {
                Screen.setText("0");
            }
        });

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Screen.getText().toString().equals("0")) {
                    Screen2.setText("Invalid Input");
                } else {
                    Double d1 = Double.valueOf(Screen.getText().toString() + "");
                    Double square = d1 * d1;
                    Screen2.setText(square.toString());
                    Screen.setText(d1 + "²");
                }
            }
        });

        equal.setOnClickListener(view -> {
            secondNum = Double.parseDouble(Screen.getText().toString());
            double result;
            switch (operation) {
                case "/":
                    result = firstNum / secondNum;
                    break;
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                case "x":
                    result = firstNum * secondNum;
                    break;
                default:
                    result = firstNum + secondNum;
            }

            String expression = firstNum + "" + operation + "" + secondNum;
            Screen.setText(expression);
            Screen2.setText(String.valueOf(result));
            firstNum = result;
        });
    }
}

