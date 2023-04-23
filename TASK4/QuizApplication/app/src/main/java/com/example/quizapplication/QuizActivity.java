package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapplication.databinding.ActivityQuizBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    ActivityQuizBinding binding;
    ArrayList<Question> questions;
    Question question;
    int index=0;
    int count=0;
    CountDownTimer timer;
    boolean flag =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        questions = new ArrayList<>();
        String catId = getIntent().getStringExtra("catId");
        String name=getIntent().getStringExtra("name");
        Log.d("swati", " Quiz Activity onCreate: "+name);
        if(catId.equals("Mathematics"))
        {
            questions.add(new Question("What is the sum of 130+125+191?","335","456","446","426","446"));
            questions.add(new Question("If we minus 712 from 1500, how much do we get??","788","778","768","758","788"));
            questions.add(new Question("50 times of 8 is equal to:","80","400","800","4000","400"));
            questions.add(new Question("110 divided by 10 is:","11","10","5","None of these","11"));
            questions.add(new Question("The product of 82 and 5 is:","400","410","420","None of these","410"));
        }
        else if(catId.equals("Science"))
        {
            questions.add(new Question("Which one of these blood types is the rarest?","A positive","O positive","B Negative","AB Negative","AB Negative"));
            questions.add(new Question("What does a ‘light year’ measure?","Sound","Distance","Speed","Time","Distance"));
            questions.add(new Question("Photosynthesis is a process created by?","Plants","Animals","Food","Cameras","Plants"));
            questions.add(new Question("How much of the Earth’s surface is covered in water?","20%","40%","50%","70%","70%"));
            questions.add(new Question("Which one of the following is the study of Earth?","Biology","Geology","Chemistry","Astronomy","Geology"));

        }
        else if(catId.equals("Language"))
        {
            questions.add(new Question(" One who abandons his religious faith ?","Apostate","Prostate","Profane","Agnostic","Apostate"));
            questions.add(new Question("tory of old time gods or heroes is ?","Lyric","Epic","Legend","Romance","Legend"));
            questions.add(new Question("Synonym of reformation is ?","repetition","change","revelation","retreat","change"));
            questions.add(new Question(" Violation of something holy or sacred is ?","profanity","sedition","sacrilege","slander","sacrilege"));
            questions.add(new Question("A person who constantly thinks, he is sick is a ?","hypochondriac","misogynist","misanthrope","hyperpitutiary","hypochondriac"));
        }
        else if(catId.equals("History"))
        {
            questions.add(new Question("In which year was the Battle of Plassey fought?","1757","1767","1769","1784","1757"));
            questions.add(new Question("Against whom was the second opium war fought by British India ?","France","China","Burma","Japan","China"));
            questions.add(new Question("Which empires ended in the World War 1?","Russian","Ottoman","German","All of the above","All of the above"));
            questions.add(new Question("Which treaty was signed after the third Anglo Maratha War?","Treaty of Mangalore","Treaty of Seringapatam","Treaty of Surji- Anjangaon","None of the above ","Treaty of Seringapatam"));
            questions.add(new Question("The Bambatha Rebellion was fought against which tribe?","Zulu","Afridi","Munda","None of the above ","Zulu"));
        }
        else if(catId.equals("Puzzle"))
        {
            questions.add(new Question("If PIG is coded as 1697, then what will be the code for GOAT?","715121","715122","715123","715120","715120"));
            questions.add(new Question("If P means ÷, Q means ×, R means +and S means −, then what is the value of 8Q24P6R10S5?","55","30","37","42","37"));
            questions.add(new Question("Happiness is to 517768399 as senipah is to","9386615","9386517","9836715","9386715","9386715"));
            questions.add(new Question("SCD, TEF, UGH, ____, WKL", "CMN","UJI","VIJ","IJT","VIJ"));
            questions.add(new Question("FAG, GAF, HAI, IAH, ____","JAK","HAL","HAK","JAI","JAK"));
        }
        else if(catId.equals("Drama"))
        {
            questions.add(new Question("Actor Sushant Singh Rajput was born in _ city ?","Ranchi","Bhopal","Patna","Mumbai","Patna"));
            questions.add(new Question("What was the Release date of Movie “Hum Aapke Hain Koun” ?","5 August 1994","5 August 1997","15 August 1997","26 January 1994","5 August 1994"));
            questions.add(new Question("Which was India’s First Sound movie ?","Alam Ara","Raja Harishchandra","Sholey","Dosti","Alam Ara"));
            questions.add(new Question("At what age, legend actor Kishore Kumar died ?","59","72","67","58","58"));
            questions.add(new Question("Who was the director of 3 idiot movie ?","Sanjay Leela Bhansali","Prakash Jha","Rajkumar Hirani","Aamir Khan","Rajkumar Hirani"));
        }
        resetTimer();
        setNextQuestion();

        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index < questions.size()-1) {
                    index++;
                    setNextQuestion();
                }
                else {
                    Intent intent = new Intent(QuizActivity.this,ResultActivity.class);
                    intent.putExtra("result",count+"");
                    intent.putExtra("name",name);
                    startActivity(intent);
                    finish();
                }
            }
        });
        binding.option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==false){
                    if(timer!=null){
                        timer.cancel();
                    }
                    TextView selected = (TextView) view;
                    CheckAnswer(selected);
                }
            }
        });
        binding.option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==false){
                    if(timer!=null){
                        timer.cancel();
                    }
                    TextView selected = (TextView) view;
                    CheckAnswer(selected);
                }
            }
        });
        binding.option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==false){
                    if(timer!=null){
                        timer.cancel();
                    }
                    TextView selected = (TextView) view;
                    CheckAnswer(selected);
                }
            }
        });
        binding.option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==false){
                    if(timer!=null){
                        timer.cancel();
                    }
                    TextView selected = (TextView) view;
                    CheckAnswer(selected);
                }
            }
        });
        binding.QuitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizActivity.this,CategoryActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
                finish();
            }
        });
    }
    void resetTimer(){
        timer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {
                binding.timer.setText(String.valueOf(l/1000));
            }
            @Override
            public void onFinish() {
                index++;
                setNextQuestion();
            }
        };
    }
    void setNextQuestion() {
        if (index < questions.size()) {
            flag=false;
            resetTimer();
            if(timer!=null){
                timer.cancel();
            }
            timer.start();
            question = questions.get(index);
            binding.questioncounter.setText(String.format("%d/%d",(index+1),questions.size()));
            binding.question.setText(question.getQuestion());
            binding.option1.setText(question.getOption1());
            binding.option2.setText(question.getOption2());
            binding.option3.setText(question.getOption3());
            binding.option4.setText(question.getOption4());
            binding.option1.setBackground(getResources().getDrawable(R.drawable.optionunselected));
            binding.option2.setBackground(getResources().getDrawable(R.drawable.optionunselected));
            binding.option3.setBackground(getResources().getDrawable(R.drawable.optionunselected));
            binding.option4.setBackground(getResources().getDrawable(R.drawable.optionunselected));
        }
    }
    void showAnswer()
    {
        if(question.getAnswer().equals(binding.option1.getText().toString()))
        {
            binding.option1.setBackground(getResources().getDrawable(R.drawable.optionright));
        }
        else if(question.getAnswer().equals(binding.option2.getText().toString()))
        {
            binding.option2.setBackground(getResources().getDrawable(R.drawable.optionright));
        }
        else if(question.getAnswer().equals(binding.option3.getText().toString()))
        {
            binding.option3.setBackground(getResources().getDrawable(R.drawable.optionright));
        }
        else if(question.getAnswer().equals(binding.option4.getText().toString()))
        {
            binding.option4.setBackground(getResources().getDrawable(R.drawable.optionright));
        }
    }
    void CheckAnswer(TextView textView){

        flag=true;
        String selectedAnswer = textView.getText().toString();
        if(selectedAnswer.equals(question.getAnswer())){
            textView.setBackground(getResources().getDrawable(R.drawable.optionright));
            count++;
        }
        else
        {
            showAnswer();
            textView.setBackground(getResources().getDrawable(R.drawable.optionwrong));
        }
    }
}