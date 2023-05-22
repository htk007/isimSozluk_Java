package com.heka.isimsozlukapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.heka.isimsozlukapp.R;
import com.heka.isimsozlukapp.adapter.NameAdapter;
import com.heka.isimsozlukapp.adapter.UsageAdapter;
import com.heka.isimsozlukapp.model.Name;
import com.heka.isimsozlukapp.model.SecretStorage;
import com.heka.isimsozlukapp.viewmodel.NameViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private EditText searchEditText;
    private Button searchButton;
    private RecyclerView nameRecyclerView;

    private NameViewModel nameViewModel;
    private NameAdapter nameAdapter;
    private UsageAdapter usageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView(){
        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);
        nameRecyclerView = findViewById(R.id.nameRecyclerView);

        nameAdapter = new NameAdapter(this, new ArrayList<>());
        usageAdapter =  new UsageAdapter(this, new ArrayList<>());
        nameRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //nameRecyclerView.setAdapter(nameAdapter);
        nameRecyclerView.setAdapter(usageAdapter);
        nameViewModel = new ViewModelProvider(this).get(NameViewModel.class);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = searchEditText.getText().toString().trim();
                if (!query.isEmpty()) {
                    nameViewModel.searchNames(query, SecretStorage.API_KEY);
                }
            }
        });

        nameViewModel.getNameList().observe(this, new Observer<List<Name>>() {
            @Override
            public void onChanged(List<Name> nameList) {

                nameAdapter.setNameList(nameList);
                usageAdapter.setUsageList(nameList.get(0).getUsages());
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}