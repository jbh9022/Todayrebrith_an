package com.jbh90.todayrebrith_an.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jbh90.todayrebrith_an.R;
import com.jbh90.todayrebrith_an.ResultActivity;

import org.w3c.dom.Text;

public class Dialog1 extends Dialog{
    private Context context;
    private TextInputEditText edt1, edt2, edt3, edt4;
    private TextView logTxt1;

    float a, b, c;
    float result;
    int slot;
    String w,x,y,z;

    public Dialog1(@NonNull Context context) {
        super(context);
        this.context = context;
    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log1);
        edt1 = (TextInputEditText) findViewById(R.id.logEdt1);
        edt2 = (TextInputEditText) findViewById(R.id.logEdt2);
        edt3 = (TextInputEditText) findViewById(R.id.logEdt3);
        edt4 = (TextInputEditText) findViewById(R.id.logEdt4);
        logTxt1 = (TextView)findViewById(R.id.logTxt1);

        logTxt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w = edt1.getText().toString();
                x = edt2.getText().toString();
                y = edt3.getText().toString();
                z = edt4.getText().toString();

                if(w.equals("") || x.equals("") || y.equals("") || z.equals("")){
                    Toast.makeText(context, "숫자를 입력해 주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    //계산
                    calculation();
                    //화면전환
                    Intent intent = new Intent(context, ResultActivity.class);
                    intent.putExtra("유물개수", slot);
                    intent.putExtra("필요배속",result);
                    //전환 애니메이션 없애기
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    context.startActivity(intent);
                    //화면전환시 밑으로 내려간 화면 닫기
                    ResultActivity resActiviey = (ResultActivity)ResultActivity.reActivity;
                    resActiviey.finish();
                    //화면닫을시 애니메이션 제거
                    resActiviey.overridePendingTransition(0,0);
                    //다이얼로그 닫기
                    dismiss();
                }
            }
        });
    }
    private void calculation(){
        a = Float.parseFloat(w);
        b = Float.parseFloat(x);
        c = Float.parseFloat(y);

        slot = Integer.parseInt(z);
        result = ((a/100) + 100) - b - c;
    }
}
