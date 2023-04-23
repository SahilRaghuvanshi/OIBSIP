package com.example.unitconverter;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.unitconverter.databinding.ActivityCurrencyBinding;
public class CurrencyActivity extends AppCompatActivity {

    ActivityCurrencyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCurrencyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CurrencyActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.box1.isFocused()){
                    if(binding.box1.getText().toString().length()!=0){
                        binding.box2.setText(((Float.parseFloat(binding.box1.getText().toString()))*0.01219)+"");
                    }
                }
                if(binding.box2.isFocused()){
                    if(binding.box2.getText().toString().length()!=0){
                        binding.box1.setText(((Float.parseFloat(binding.box2.getText().toString()))/0.01219)+"");
                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(CurrencyActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}