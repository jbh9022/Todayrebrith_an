package com.jbh90.todayrebrith_an;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2, edt3, edt4;
    Button btn1;
    float a, b, c;
    float result, num1;
    int slot;
    String w,x,y,z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       init();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                w = edt1.getText().toString();
                x = edt2.getText().toString();
                y = edt3.getText().toString();
                z = edt4.getText().toString();

                if(w.equals("") || x.equals("") || y.equals("") || z.equals("")){
                    Toast.makeText(MainActivity.this, "숫자를 입력해 주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    calculation();
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("필요배속", result);
                    intent.putExtra("유물개수",slot);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }

    private void init(){
        //edt1 = 최고층
        edt1 = (EditText)findViewById(R.id.edt1);
        //edt2 =  팻속도
        edt2 = (EditText)findViewById(R.id.edt2);
        //edt3 = 병사속도
        edt3 = (EditText)findViewById(R.id.edt3);
        //edt4 = 유물개수
        edt4 = (EditText)findViewById(R.id.edt4);
        btn1 = (Button)findViewById(R.id.btn1);

    }
    private void calculation(){
        a = Float.parseFloat(w);
        b = Float.parseFloat(x);
        c = Float.parseFloat(y);

        slot = Integer.parseInt(z);
        result = ((a/100) + 100) - b - c;
    }
}
