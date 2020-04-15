package com.lec.android.a003_listener;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    EditText et;
    int buff1 = 0;
    int buff2 = 0;
    String op = "";
    int result = 0;

    // 과제 : 계산기 앱 만들기
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et =findViewById(R.id.et);

        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btnDiv = findViewById(R.id.btnDiv);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnEql = findViewById(R.id.btnEql);

        class CalcBtnListener implements View.OnClickListener {
            String name;

            public CalcBtnListener(String name) {this.name = name;}

            @Override
            public void onClick(View v) {
                String text = (String)((Button)v).getText();  // getText() 는 CharSequence 객체 리턴
                String msg = String.format("%s 버튼 클릭", text);
                Log.d("myapp", msg);
                et.setText(et.getText().append(name));
            }
        }

        btn0.setOnClickListener(new CalcBtnListener("0"));
        btn1.setOnClickListener(new CalcBtnListener("1"));
        btn2.setOnClickListener(new CalcBtnListener("2"));
        btn3.setOnClickListener(new CalcBtnListener("3"));
        btn4.setOnClickListener(new CalcBtnListener("4"));
        btn5.setOnClickListener(new CalcBtnListener("5"));
        btn6.setOnClickListener(new CalcBtnListener("6"));
        btn7.setOnClickListener(new CalcBtnListener("7"));
        btn8.setOnClickListener(new CalcBtnListener("8"));
        btn9.setOnClickListener(new CalcBtnListener("9"));
        btnDiv.setOnClickListener(new CalcBtnListener("÷"));
        btnMul.setOnClickListener(new CalcBtnListener("×"));
        btnSub.setOnClickListener(new CalcBtnListener("-"));
        btnAdd.setOnClickListener(new CalcBtnListener("+"));

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "Clear 버튼이 클릭 되었습니다");
                et.setText("");
                buff1 = 0;
                buff2 = 0;
                op = "";
                result = 0;
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "÷ 버튼이 클릭 되었습니다");
                buff1 = Integer.parseInt(et.getText().toString());
                et.setText("");
                op = "Div";
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "× 버튼이 클릭 되었습니다");
                buff1 = Integer.parseInt(et.getText().toString());
                et.setText("");
                op = "Mul";
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "- 버튼이 클릭 되었습니다");
                buff1 = Integer.parseInt(et.getText().toString());
                et.setText("");
                op = "Sub";
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myapp", "+ 버튼이 클릭 되었습니다");
                buff1 = Integer.parseInt(et.getText().toString());
                et.setText("");
                op = "Add";
            }
        });

        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buff2 = Integer.parseInt(et.getText().toString());
                switch (op) {
                    case "Div":
                        if(buff1 != 0 && buff2 != 0) {
                            result = buff1 / buff2;
                            break;
                        }
                    case "Mul" :
                        result = buff1 * buff2;
                        break;
                    case "Sub" :
                        result = buff1 - buff2;
                        break;
                    case "Add" :
                        result = buff1 + buff2;
                        break;
                }
                et.setText(Integer.toString(result));
                buff1 = 0;
                buff2 = 0;
                op = "";
                result = 0;
            }
        });

    } // end onCreate

} // end Activity
