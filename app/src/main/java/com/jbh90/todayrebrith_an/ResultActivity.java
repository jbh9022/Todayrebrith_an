package com.jbh90.todayrebrith_an;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class ResultActivity extends AppCompatActivity {
    private float result;
    private int slot;
    private TextView text1, text2, resultNum, resultSpeed, resultPoint;
    private RecyclerView reView;
    ArrayList<Post> list;
    private adapter adapter;
    int phoneWidth, phoneHeigth;
    private LinearLayout reLay1, reLay2, reLay3, reLay4, reLay5;
    private LinearLayout reLay2_1, reLay2_2, reLay2_3, reLay2_4, reLay2_5;
    int width1, heigth1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        init();
        listAdd();
        sizePhone();

        Intent intent = getIntent();
        result = intent.getFloatExtra("필요배속", 0);
        slot = intent.getIntExtra("유물개수",0);
        text1.setText(String.valueOf(slot));
        text2.setText(String.valueOf(result));

        layoutSize();

        reView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new adapter(this, list, R.layout.page1, width1, heigth1);
        reView.setAdapter(adapter);

//        resultNum.setText();
//        resultSpeed.setText();
//        resultPoint.setText();

    }

    private void  sizePhone(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        phoneWidth = size.x-100;
        phoneHeigth=size.y-200;
        width1 = phoneWidth/15;
        heigth1 = phoneHeigth/10;
    }

    private void layoutSize(){
        reLay1.setLayoutParams(new LinearLayout.LayoutParams(width1 * 4, heigth1/2));
        reLay2.setLayoutParams(new LinearLayout.LayoutParams(width1 * 3, heigth1/2));
        reLay3.setLayoutParams(new LinearLayout.LayoutParams(width1 * 3, heigth1/2));
        reLay4.setLayoutParams(new LinearLayout.LayoutParams(width1 * 2, heigth1/2));
        reLay5.setLayoutParams(new LinearLayout.LayoutParams(width1 * 3, heigth1/2));

        reLay2_1.setLayoutParams(new LinearLayout.LayoutParams(width1 * 4, heigth1/2));
        reLay2_2.setLayoutParams(new LinearLayout.LayoutParams(width1 * 3, heigth1/2));
        reLay2_3.setLayoutParams(new LinearLayout.LayoutParams(width1 * 3, heigth1/2));
        reLay2_4.setLayoutParams(new LinearLayout.LayoutParams(width1 * 2, heigth1/2));
        reLay2_5.setLayoutParams(new LinearLayout.LayoutParams(width1 * 3, heigth1/2));
    }

    private void init(){
        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
        resultNum = (TextView)findViewById(R.id.resultNum);
        resultSpeed = (TextView)findViewById(R.id.resultSpeed);
        resultPoint = (TextView)findViewById(R.id.resultPoint);

        reLay1 = (LinearLayout)findViewById(R.id.reLay1);
        reLay2 = (LinearLayout)findViewById(R.id.reLay2);
        reLay3 = (LinearLayout)findViewById(R.id.reLay3);
        reLay4 = (LinearLayout)findViewById(R.id.reLay4);
        reLay5 = (LinearLayout)findViewById(R.id.reLay5);

        reLay2_1 = (LinearLayout)findViewById(R.id.reLay2_1);
        reLay2_2 = (LinearLayout)findViewById(R.id.reLay2_2);
        reLay2_3 = (LinearLayout)findViewById(R.id.reLay2_3);
        reLay2_4 = (LinearLayout)findViewById(R.id.reLay2_4);
        reLay2_5 = (LinearLayout)findViewById(R.id.reLay2_5);

        reView = (RecyclerView)findViewById(R.id.reView);
        list = new ArrayList<Post>();
    }
    private void listAdd(){
        list.clear();
        list.add(new Post("(7성)일반 고대"));
        list.add(new Post("(7성)일반 불대"));
        list.add(new Post("(7성)일반 늡지"));
        list.add(new Post("(7성)일반 지옥"));
        list.add(new Post("(7성)상급 고대"));
        list.add(new Post("(7성)상급 불대"));
        list.add(new Post("(7성)상급 늡지"));
        list.add(new Post("(7성)차원의 신기"));
        list.add(new Post("(7성)영웅의 무기"));
        list.add(new Post("(7성)승리의 성물"));
        list.add(new Post("(7성)권위의 성물"));
        list.add(new Post("(7성)풍요의 서물"));
        list.add(new Post("(7성)유희의 성물"));
        list.add(new Post("(7성)신들의 보물"));
        list.add(new Post("(7성)라그나로크의 경고"));
        list.add(new Post("(7성)고대 신화의 무기"));
        list.add(new Post("(6성)초신성의 강림자"));
        list.add(new Post("(6성)정의의 신궁"));
        list.add(new Post("(6성)암흑 군단자의 전투복"));
        list.add(new Post("(6성)빙결의 기사 무장"));
        list.add(new Post("(6성)야차왕의 무구"));
        list.add(new Post("(6성)풍요의 유산"));
        list.add(new Post("(6성)고대 차원수의 무장"));
    }
}
