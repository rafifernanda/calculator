package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    Button bdiv,bplus,bequ,bmin,bclear,bdel,bper,bdot, bmul,bkwa;

    EditText et;
    StringBuffer num;
    int op;

    double num1, num2, result = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = new StringBuffer();

        b0 = findViewById(R.id.button0);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);


        ButtonNum bn = new ButtonNum();

        b0.setOnClickListener(bn);
        b1.setOnClickListener(bn);
        b2.setOnClickListener(bn);
        b3.setOnClickListener(bn);
        b4.setOnClickListener(bn);
        b5.setOnClickListener(bn);
        b6.setOnClickListener(bn);
        b7.setOnClickListener(bn);
        b8.setOnClickListener(bn);
        b9.setOnClickListener(bn);

        bclear = findViewById(R.id.buttonclear);
        bmin = findViewById(R.id.buttonmin);
        bmul = findViewById(R.id.buttonmul);
        bplus = findViewById(R.id.buttonplus);
        bdiv = findViewById(R.id.buttondiv);
        bequ = findViewById(R.id.buttonequals);

        ButtonOp bo = new ButtonOp();

        bplus.setOnClickListener(bo);
        bmul.setOnClickListener(bo);
        bmin.setOnClickListener(bo);
        bdiv.setOnClickListener(bo);

        bkwa = (Button) findViewById(R.id.buttonkuadrat);
        bkwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et = (EditText) findViewById(R.id.editText1);
                num1 = Double.parseDouble(et.getText().toString());
                result = num1 * num1;
                et.setText(""+result);
                num1 = 0;
                num2 = 0;
                result = 0;
                num.delete(0,num.length());
            }
        });

        bclear = (Button) findViewById(R.id.buttonclear);
        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = 0;
                num2 = 0;
                op = 0;
                result = 0;
                et = (EditText) findViewById(R.id.editText1);
                et.setText("");
                num.delete(0, num.length());
            }
        });

        bdel = findViewById(R.id.buttondel);
        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = et.getText().length();
                if (length > 0) {
                    et.getText().delete(length - 1, length);
                }
            }
        });

        bper = findViewById(R.id.buttonpersen);
        bper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et = (EditText) findViewById(R.id.editText1);
                num1 = Double.parseDouble(et.getText().toString());
                result = num1 / 100;
                et.setText(""+result);
                num1 = 0;
                num2 = 0;
                result = 0;
                num.delete(0,num.length());
            }
        });

        bdot = (Button) findViewById(R.id.buttonpoint);
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et = (EditText) findViewById(R.id.editText1);
                String s = et.getText().toString();
                if (s.indexOf(".") == -1){
                    num.append(".");
                    et.setText(num);
                }
            }
        });

        bequ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et = (EditText) findViewById(R.id.editText1);
                String number2 = et.getText().toString();
                if(number2 != null || !number2.equalsIgnoreCase("")){
                    num2 = Double.parseDouble(number2);
                    switch (op){
                        case 1:
                            result = num1 + num2;
                            break;

                        case 2:
                            result = num1 - num2;
                            break;
                        case 3:
                            result = num1 * num2;
                            break;
                        case 4:
                            result = num1 / num2;
                            break;
                    }
                    et.setText(""+result);
                    num1 = 0;
                    num2 = 0;
                    result = 0;
                    num.delete(0,num.length());
                }


            }
        });

    }
    private class ButtonNum implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            et = (EditText) findViewById(R.id.editText1);
            Button b = (Button) v;
            et.setText("");
            num.append(b.getText());
            et.setText(num);

        }
    }


    private class ButtonOp implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            et = (EditText) findViewById(R.id.editText1);
            num1 = Double.parseDouble(et.getText().toString());
            et.setText("");
            num.delete(0, num.length());

            switch(v.getId()){
                case R.id.buttonplus:
                    op=1;
                    et.setText("+");
                    break;
                case R.id.buttonmin:
                    et.setText("-");
                    op=2;
                    break;
                case R.id.buttonmul:
                    et.setText("X");
                    op=3;
                    break;
                case R.id.buttondiv:
                    et.setText("/");
                    op=4;
                    break;
            }
        }
    }

}
