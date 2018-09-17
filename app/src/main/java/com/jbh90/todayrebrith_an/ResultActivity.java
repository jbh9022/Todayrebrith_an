package com.jbh90.todayrebrith_an;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


import com.jbh90.todayrebrith_an.dialog.Dialog1;

import java.util.ArrayList;


public class ResultActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static ResultActivity reActivity;
    private float result;
    private int slot;
    int phoneWidth, phoneHeigth;
    private LinearLayout layOut1;
    int width1, heigth1;
    private ArrayList<Post> list;
    TextView text1, text2, text3, text4;
    public Spinner selSp1, selSp2, selSp3, selSp4;

    String spd1;
    String  hun1;
    String[] sp_Rank;

    String[] sp_Rank_6Name;
    String[] sp_Rank_7ch;
    String[] sp_Rank_6ch;

    String a, b,c, d;
    //7성
    String[] sel_7Name = {"일반 고대", "일반 불대","일반 늡지", "일반 지옥", "상급 고대",
            "상급 불대", "상급 늡지", "차원의 신기", "영웅의 무기", "승리의 성물",
            "권위의 성물", "풍요의 성물", "유희의 성물", "신들의 보물", "라그나로크의 경고", "고대 신화의 무기"};
//    //6성
//    String[] select_2 = {"유물을 선택하세요","초신성의 강림자","정의의 신궁", "암흑 군단자의 전투복", "빙결의 기사 무장", "야차왕의 무구",
//            "풍요의 유산", "고대 차원수의 무장"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //액티비티 지정!!
        reActivity = ResultActivity.this;

        //다이얼로그 계산값 받아오기
        Intent intent  = getIntent();
        slot = intent.getIntExtra("유물개수", slot);
        result = intent.getFloatExtra("필요배속", result);
        sp_Rank= getResources().getStringArray(R.array.sp_Rank);
        sp_Rank_7ch = getResources().getStringArray(R.array.sp_Rank_7ch);
        sp_Rank_6ch= getResources().getStringArray(R.array.sp_Rank_6ch);
        sp_Rank_6Name= getResources().getStringArray(R.array.sp_Rank_6Name);
//        sp_Rank_7Name= getResources().getStringArray(R.array.sp_Rank_7Name);
        init();
        sizePhone();

        text1.setText(String.valueOf(slot));
        text2.setText(String.valueOf(result));

        //다이얼로그 실행
        layOut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog1 dialog = new Dialog1(ResultActivity.this);
                dialog.show();
            }
        });

        selSp1.setOnItemSelectedListener(this);
        ArrayAdapter<String> selSp1_Adapter = new ArrayAdapter<String>(this ,R.layout.support_simple_spinner_dropdown_item, sp_Rank);
        selSp1.setAdapter(selSp1_Adapter);


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

    private void init(){

        layOut1 = (LinearLayout)findViewById(R.id.layOut1);
        text1 = (TextView)findViewById(R.id.text1);
        text2 = (TextView)findViewById(R.id.text2);
        text3 = (TextView)findViewById(R.id.text3);
        text4 = (TextView)findViewById(R.id.text4);

        selSp1 = (Spinner)findViewById(R.id.selSp1);
        selSp2 = (Spinner)findViewById(R.id.selSp2);
        selSp3 = (Spinner)findViewById(R.id.selSp3);
        selSp4 = (Spinner)findViewById(R.id.selSp4);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //등급 설정
           switch (position) {
               //7성
               case 0:
                   //7성 초월 수
                   sel7_ch();
                   break;
                   //6성
               case 1:
                   //6성 초월 수
                   sel6_ch();

                   break;
           }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
//7성 초월 수
    private void sel7_ch(){
        selSp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0 :
                        //7성 세트
                        sel7_set();
                        break;
                    case 1:
                        //7성 세트
                        sel7_set();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> sel7ch_Adapter = new ArrayAdapter<String>(this ,R.layout.support_simple_spinner_dropdown_item, sp_Rank_7ch);
        selSp2.setAdapter(sel7ch_Adapter);
    }
    //6성 초월 수
    private void sel6_ch(){
        selSp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> sel6ch_Adapter = new ArrayAdapter<String>(this ,R.layout.support_simple_spinner_dropdown_item, sp_Rank_6ch);
        selSp2.setAdapter(sel6ch_Adapter);
    }
//7성 장비 개수 선택
    private void sel7_set(){
        selSp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    //일반 고대
                    case 0:
                        String[] set0={"2", "4"};
                        selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                               if(selSp4.getSelectedItem().equals("2")){
                                       if(selSp2.getSelectedItem().equals("0초")){
                                       spd1 = "37";
                                       hun1 = "0";
                                   }
                                   if(selSp2.getSelectedItem().equals("1초")){
                                       spd1 = "38";
                                       hun1 = "0";
                                   }

                                   }
                                   if(selSp4.getSelectedItem().equals("4")){
                                       if(selSp2.getSelectedItem().equals("0초")){
                                           spd1 = "37";
                                           hun1 = "360";
                                       }
                                       if(selSp2.getSelectedItem().equals("1초")){
                                           spd1 = "38";
                                           hun1 = "830";
                                       }
                               }
                                text3.setText(spd1);
                                text4.setText(hun1);
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                        ArrayAdapter<String> sel4_0 = new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, set0);
                        selSp4.setAdapter(sel4_0);

                        break;
                        //일반 불대
                    case 1:
                        String[] set1={"2", "5"};
                        selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 0:
                                        if(selSp2.getSelectedItem().equals("0초")){
                                            spd1 = "37";
                                            hun1 = "0";
                                        }
                                        if(selSp2.getSelectedItem().equals("1초")){
                                            spd1 = "38";
                                            hun1 = "0";
                                        }
                                        break;
                                    case 1:
                                        if(selSp2.getSelectedItem().equals("0초")){
                                            spd1 = "37";
                                            hun1 = "600";
                                        }
                                        if(selSp2.getSelectedItem().equals("1초")){
                                            spd1 = "38";
                                            hun1 = "1250";
                                        }
                                        break;
                                }
                                text3.setText(spd1);
                                text4.setText(hun1);
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                        ArrayAdapter<String> sel4_1= new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, set1);
                        selSp4.setAdapter(sel4_1);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                    case 15:
                        break;
                    case 16:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> sel3Adapter = new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, sel_7Name);
        selSp3.setAdapter(sel3Adapter);


    }
}
