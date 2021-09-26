package com.example.week2project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.week2project.Calculator;

public class MainActivity extends AppCompatActivity {
    public static final String tag = "Week2";

    Calculator cal = new Calculator();

    TextView result;
    TextView advance_result;

    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;
    Button c;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    Button equal;

    List<String> params = new ArrayList<String>();
    List<String> history = new ArrayList<String>();

    String result_display = "";
    String num = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);
        advance_result = (TextView) findViewById(R.id.resultComp);

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        c = (Button) findViewById(R.id.c);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        equal = (Button) findViewById(R.id.equal);
    }

    public void advanceClick(View v) {
        String tmp = "";

        for (String item:
                history) {
            tmp += item;
            tmp += "\n";
        }

        advance_result.setText(tmp);
    }

    public void numClick(View v) {
        String text = ((Button) v).getText().toString();
        result_display += text;
        num += text;

        result.setText(result_display);
    }

    public void opClick(View v) {
        String text = ((Button) v).getText().toString();

        if (num != "") {
            params.add(num);
            num = "";
        }

        if (params.size() < 1) {
            params.add("0");

            result_display += "0";
            result.setText(result_display);

            params.add(text);
        } else if (params.size() > 0 && ! cal.isNum(params.get(params.size() - 1))) {
            params.set(params.size() - 1, text);
        } else {
            params.add(text);
        }
        result_display += "  " + text + " ";
        result.setText(result_display);
    }

    public void clickEqual(View v) {
        String text = ((Button) v).getText().toString();

        if (num != "") {
            params.add(num);
            num = "";
        }

        params.add(text);

        result_display += " " + text + " ";
        result.setText(result_display);
        float tmp_result = 0;

        for (int i = 1; i + 2 < params.size(); i = i + 2) {

            if (i == 1) {
                tmp_result = cal.operator(Float.parseFloat(params.get(i - 1)), Float.parseFloat(params.get(i + 1)), params.get(i));
            } else {
                tmp_result = cal.operator(tmp_result, Float.parseFloat(params.get(i + 1)), params.get(i));
            }
        }
        result_display += String.valueOf(tmp_result);
        result.setText(result_display);

        history.add(result_display);
        params.clear();
        result_display = "";
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "in onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "in onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "in onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "in onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "in onDestroy");
    }
}