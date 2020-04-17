package com.lec.android.a008_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etAge;
    EditText etAddr;

    RecyclerView rv;
    ProfileAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etAddr = findViewById(R.id.etAddr);

        // 포커스 받은 입력창 배경색 변경
        class FocusHighlight implements View.OnFocusChangeListener {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    ((EditText)v).setBackgroundColor(Color.parseColor("#FCE4EC"));
                } else {
                    ((EditText)v).setBackgroundColor(Color.parseColor("#00000000"));
                }
            }
        }

        etName.setOnFocusChangeListener(new FocusHighlight());
        etAge.setOnFocusChangeListener(new FocusHighlight());
        etAddr.setOnFocusChangeListener(new FocusHighlight());

        rv = findViewById(R.id.rv);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        adapter = new ProfileAdapter();
        rv.setAdapter(adapter);

        Button btnInsert = findViewById(R.id.btnInsert);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData(v);
            }
        });

    } // end onCreate()

    // 추가 버튼 누르면 item 추가, (이름, 나이를 입력하지 않으면 토스트 메세지 출력)
    protected void insertData(View v) {
        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        String addr = etAddr.getText().toString();

        if(name.trim().equals("") || age.trim().equals("")) {
            Toast.makeText(v.getContext(), "이름, 나이는 꼭 입력해주세요!", Toast.LENGTH_SHORT).show();
        } else {
            adapter.addItem(0, new Profile(name, age, addr));
            adapter.notifyDataSetChanged();
        }
    }

} // end Activity
