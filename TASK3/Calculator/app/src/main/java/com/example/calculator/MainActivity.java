package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    MaterialButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    MaterialButton C,open,close,divide,multiply,minus,plus,equals,dot,AC;
    TextView result,solution;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        result=findViewById(R.id.result);
        solution=findViewById(R.id.solution);
        assignId(btn1,R.id.btn1);
        assignId(btn2,R.id.btn2);
        assignId(btn3,R.id.btn3);
        assignId(btn4,R.id.btn4);
        assignId(btn5,R.id.btn5);
        assignId(btn6,R.id.btn6);
        assignId(btn7,R.id.btn7);
        assignId(btn8,R.id.btn8);
        assignId(btn9,R.id.btn9);
        assignId(btn0,R.id.btn0);
        assignId(C,R.id.C);
        assignId(AC,R.id.btnAC);
        assignId(open,R.id.open_bracket);
        assignId(close,R.id.close_bracket);
        assignId(dot,R.id.decimal);
        assignId(plus,R.id.plus);
        assignId(multiply,R.id.multiply);
        assignId(divide,R.id.divide);
        assignId(equals,R.id.equals);
        assignId(minus,R.id.minus);
    }
    void assignId(MaterialButton btn,int id)
    {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solution.getText().toString();
        if(buttonText.equals("AC"))
        {
            solution.setText("");
            result.setText("0");
            return;
        }
        if(buttonText.equals("="))
        {
            solution.setText(result.getText());
            return;
        }
        if(buttonText.equals("C"))
        {
            if(dataToCalculate.length()-1>=0) {
                dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
            }
        }
        else
        {
            dataToCalculate=dataToCalculate+buttonText;
        }
        solution.setText(dataToCalculate);
        String finalResult=getResult(dataToCalculate);
        if(!finalResult.equals("ERR")){
            result.setText(finalResult);
        }

    }
    String getResult(String data)
    {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            String finalresult =context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if(finalresult.endsWith(".0")){
                finalresult = finalresult.replace(".0","");
            }
            if(finalresult.equals("org.mozilla.javascript.Undefined@0"))
            {
                return "0";
            }
            return finalresult;
        }
        catch(Exception e){
            return "ERR";
        }
    }
}