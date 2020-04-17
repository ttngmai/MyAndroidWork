package com.lec.android.a008_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileDetail extends AppCompatActivity {

    TextView tvName, tvAge, tvAddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);

        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        tvAddr = findViewById(R.id.tvAddr);

        Intent intent = getIntent();
        Profile pf = (Profile)intent.getSerializableExtra("pf");
        tvName.setText(pf.getName());
        tvAge.setText(pf.getAge());
        tvAddr.setText(pf.getAddr());

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
