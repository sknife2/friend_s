package com.example.app10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView_1;
    private String firstNum="";
    private String operation="";
    private String secondNum="";
    private String result="";
    private String showText="0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_1 = findViewById(R.id.tv_2);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        findViewById(R.id.btn_divide).setOnClickListener(this);
        findViewById(R.id.btn_dot).setOnClickListener(this);
        findViewById(R.id.btn_eight).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);
        findViewById(R.id.btn_five).setOnClickListener(this);
        findViewById(R.id.btn_four).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_multiply).setOnClickListener(this);
        findViewById(R.id.btn_nine).setOnClickListener(this);
        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_reciprocal).setOnClickListener(this);
        findViewById(R.id.btn_seven).setOnClickListener(this);
        findViewById(R.id.btn_six).setOnClickListener(this);
        findViewById(R.id.btn_sqrt).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);
        findViewById(R.id.btn_zero).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String inputText;
        if(view.getId()==R.id.btn_sqrt){
            inputText="√";
        }else {
            inputText=((TextView) view).getText().toString();
        }
        switch (view.getId()){
            case R.id.btn_clear:
                clear();
                break;
            case R.id.btn_cancel:
                break;
            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                operation=inputText;
                refresh(showText+inputText);
                break;
            case R.id.btn_equal:
                double calculate_result=calculateFour();
                refreshOperator(String.valueOf(calculate_result));
                refresh("="+result);
                break;
            case R.id.btn_sqrt:
                double sqrt_result=Math.sqrt(Double.parseDouble(firstNum));
                refreshOperator(String.valueOf(sqrt_result));
                refresh("="+result);
                break;
            case R.id.btn_reciprocal:
                double reciprocal_result=1.0/Double.parseDouble(firstNum);
                refreshOperator(String.valueOf(reciprocal_result));
                refresh("="+result);
                break;
            default:
                if (operation.equals("")){
                    firstNum+=inputText;
                }else {
                    secondNum+=inputText;
                }
            if (showText.equals("0")&&!inputText.equals(".")){
                refresh(inputText);
            }else refresh(showText + inputText);
                break;
        }
    }

    private double calculateFour() {
        switch (operation){
            case "+":
                return Double.parseDouble(firstNum)+Double.parseDouble(secondNum);
            case "-":
                return Double.parseDouble(firstNum)-Double.parseDouble(secondNum);
            case "*":
                return Double.parseDouble(firstNum)*Double.parseDouble(secondNum);
            case"/":
                return Double.parseDouble(firstNum)/Double.parseDouble(secondNum);
        }
        return 0;
    }

    private void clear(){
        refreshOperator("");
        refresh("");
    }
    private void refreshOperator(String new_result){
        result=new_result;
        firstNum=result;
        secondNum="";
        operation="";
    }

    private void refresh(String Text){
        showText=Text;
        textView_1.setText(showText);
    }
}