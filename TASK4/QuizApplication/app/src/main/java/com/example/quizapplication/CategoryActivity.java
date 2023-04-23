package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.quizapplication.databinding.ActivityCategoryBinding;

public class CategoryActivity extends AppCompatActivity {

    ActivityCategoryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String name=getIntent().getStringExtra("name");
        getSupportActionBar().hide();
        Log.d("swati", " Category Activity onCreate: "+name);
        binding.mathematics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this,QuizActivity.class);
                intent.putExtra("catId", "Mathematics");
                intent.putExtra("name",name);
                startActivity(intent);
                finish();
            }
        });
        binding.science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this,QuizActivity.class);
                intent.putExtra("catId", "Science");
                intent.putExtra("name",name);
                startActivity(intent);
                finish();
            }
        });
        binding.Language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this,QuizActivity.class);
                intent.putExtra("catId", "Language");
                intent.putExtra("name",name);
                startActivity(intent);
                finish();
            }
        });
        binding.History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this,QuizActivity.class);
                intent.putExtra("catId","History");
                intent.putExtra("name",name);
                startActivity(intent);
                finish();
            }
        });
        binding.puzzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this,QuizActivity.class);
                intent.putExtra("catId", "Puzzle");
                intent.putExtra("name",name);
                startActivity(intent);
                finish();
            }
        });
        binding.drama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this,QuizActivity.class);
                intent.putExtra("catId","Drama");
                intent.putExtra("name",name);
                startActivity(intent);
                finish();
            }
        });
    }
}