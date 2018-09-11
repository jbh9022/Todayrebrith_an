package com.jbh90.todayrebrith_an;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private float result;
    private int slot;
    private TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();

        Intent intent = getIntent();
        result = intent.getFloatExtra("필요배속", 0);
        slot = intent.getIntExtra("유물개수",0);
        text1.setText(String.valueOf(result));
        text2.setText(String.valueOf(slot));
    }


    private void init(){
        text1 = (TextView)findViewById(R.id.resultText1);
        text2 = (TextView)findViewById(R.id.resultText2);

    }
}
