package com.example.unitconverter;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.unitconverter.databinding.ActivityCurrencyBinding;
import com.example.unitconverter.databinding.ActivityTimeBinding;
public class TimeActivity extends AppCompatActivity {
    ActivityTimeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTimeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TimeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.box1.isFocused()){
                    if(binding.box1.getText().toString().length()!=0){
                        binding.box2.setText(((Float.parseFloat(binding.box1.getText().toString()))/60)+"");
                    }
                }
                if(binding.box2.isFocused()){
                    if(binding.box2.getText().toString().length()!=0){
                        binding.box1.setText(((Float.parseFloat(binding.box2.getText().toString()))*60)+"");
                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(TimeActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}