package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.quizapplication.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        binding.takequiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.Name.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Enter Your Name !", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                    intent.putExtra("name",binding.Name.getText().toString());
                    binding.Name.setText("");
                    startActivity(intent);
                }
            }
        });
    }
}