package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.stopwatch.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int second =0;
    private boolean running;
    private boolean wasRunning;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        if(savedInstanceState!=null)
        {
            second=savedInstanceState.getInt("seconds");
            running=savedInstanceState.getBoolean("running");
            wasRunning=savedInstanceState.getBoolean("wasRunning");
        }
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours =second/3600;
                int minutes = (second%3600)/60;
                int secs = second % 60;
                String time=String.format(Locale.getDefault(),"%02d:%02d:%02d",hours,minutes,secs);
                binding.textView.setText(time);
                if(running)
                {
                    second++;
                }
                handler.postDelayed(this,1000);
            }
        });
        binding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running=true;

            }
        });
        binding.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running=false;
                second=0;
            }
        });
        binding.pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running=false;
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning=running;
        running=false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(wasRunning){
            running=true;
        }
    }
}