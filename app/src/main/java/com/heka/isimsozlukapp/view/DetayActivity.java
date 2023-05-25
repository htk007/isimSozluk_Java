package com.heka.isimsozlukapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.heka.isimsozlukapp.R;
import com.heka.isimsozlukapp.util.PreferencesUtil;

public class DetayActivity extends AppCompatActivity {

    TextView tvSelectedInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
        initView();
        Intent intent = getIntent();
        String usage = intent.getStringExtra("usage");
        String name= PreferencesUtil.getString(getApplicationContext());
        tvSelectedInfo.setText("name: " +name +" :: "+ "usage: "+ usage);
    }

    private void initView(){
        tvSelectedInfo = findViewById(R.id.tvSelectedInfo);
    }
}