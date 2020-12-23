package com.example.calcapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button add, subtr, mul, divide;
    TextView answer;
    EditText arg1, arg2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mul = findViewById(R.id.mul);
        divide = findViewById(R.id.divide);
        add = findViewById(R.id.add);
        subtr = findViewById(R.id.subtr);
        answer = findViewById(R.id.answer);
        arg1 = findViewById(R.id.arg1);
        arg2 = findViewById(R.id.arg2);

        View.OnClickListener click =  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int n1 = Integer.parseInt(arg1.getText().toString());
                    int n2 = Integer.parseInt(arg2.getText().toString());
                    String output = "";
                    switch (v.getId()){
                        case R.id.add:
                            output = Integer.toString(n1+n2);
                            break;
                        case R.id.subtr:
                            output = Integer.toString(n1-n2);
                            break;
                        case R.id.mul:
                            output = Integer.toString(n1*n2);
                            break;
                        case R.id.divide:
                            output = Integer.toString((int)(n1/n2));
                            break;
                    }
                    answer.setText(output);
                }
                catch (NumberFormatException e) {
                    answer.setText(R.string.input_err);
                }
                catch (ArithmeticException e){
                    answer.setText(R.string.div_zero);
                }
            }
        };
        mul.setOnClickListener(click);
        add.setOnClickListener(click);
        subtr.setOnClickListener(click);
        divide.setOnClickListener(click);
    }
}
