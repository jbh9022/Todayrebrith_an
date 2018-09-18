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

    //등급 설정
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

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
                switch (position){
                    case 0:
                        sel6_set();
                        break;
                    case 1:
                        sel6_set();
                        break;
                    case 2:
                        sel6_set();
                        break;
                    case 3:
                        sel6_set();
                        break;
                }
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
                    //일반 늡지
                    case 2:
                        String[] set2 = {"5"};
                        selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 0 :
                                        if (selSp2.getSelectedItem().equals("0초")){
                                            spd1 = "0";
                                            hun1 = "600";
                                        }
                                        if (selSp2.getSelectedItem().equals("1초")){
                                            spd1 = "0";
                                            hun1 = "1450";
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
                        ArrayAdapter<String> sel4_2= new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, set2);
                        selSp4.setAdapter(sel4_2);
                        break;
                        //일반 지옥
                    case 3:
                        String[] set3 = {"6"};
                        selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 0 :
                                        if (selSp2.getSelectedItem().equals("0초")){
                                            spd1 = "0";
                                            hun1 = "800";
                                        }
                                        if (selSp2.getSelectedItem().equals("1초")){
                                            spd1 = "0";
                                            hun1 = "1480";
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
                        ArrayAdapter<String> sel4_3= new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, set3);
                        selSp4.setAdapter(sel4_3);
                        break;
                        //상급 고대
                    case 4:
                        String[] set4={"2", "4"};
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
                                        hun1 = "450";
                                    }
                                    if(selSp2.getSelectedItem().equals("1초")){
                                        spd1 = "38";
                                        hun1 = "1250";
                                    }
                                }
                                text3.setText(spd1);
                                text4.setText(hun1);
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                        ArrayAdapter<String> sel4_4 = new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, set4);
                        selSp4.setAdapter(sel4_4);
                        break;
                        //상급 불대
                    case 5:
                        String[] set5={"2", "4"};
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
                                            hun1 = "450";
                                        }
                                        if(selSp2.getSelectedItem().equals("1초")){
                                            spd1 = "38";
                                            hun1 = "1480";
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
                        ArrayAdapter<String> sel4_5= new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, set5);
                        selSp4.setAdapter(sel4_5);
                        break;
                        //상급 늡지
                    case 6:
                        String[] set6 = {"4"};
                        selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 0 :
                                        if (selSp2.getSelectedItem().equals("0초")){
                                            spd1 = "0";
                                            hun1 = "480";
                                        }
                                        if (selSp2.getSelectedItem().equals("1초")){
                                            spd1 = "0";
                                            hun1 = "1520";
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
                        ArrayAdapter<String> sel4_6= new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, set6);
                        selSp4.setAdapter(sel4_6);
                        break;
                        // 차원의 신기
                    case 7:
                        String[] set7 = {"6"};
                        selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 0 :
                                        if (selSp2.getSelectedItem().equals("0초")){
                                            spd1 = "0";
                                            hun1 = "800";
                                        }
                                        if (selSp2.getSelectedItem().equals("1초")){
                                            spd1 = "0";
                                            hun1 = "1650";
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
                        ArrayAdapter<String> sel4_7= new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, set7);
                        selSp4.setAdapter(sel4_7);
                        break;
                        //영웅의 무기
                    case 8:
                        String[] set8 = {"4"};
                        selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 0 :
                                        if (selSp2.getSelectedItem().equals("0초")){
                                            spd1 = "0";
                                            hun1 = "450";
                                        }
                                        if (selSp2.getSelectedItem().equals("1초")){
                                            spd1 = "0";
                                            hun1 = "920";
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
                        ArrayAdapter<String> sel4_8= new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, set8);
                        selSp4.setAdapter(sel4_8);
                        break;
                        //승리의 성물
                    case 9:
                        String[] set9 = {"3"};
                        selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 0 :
                                        if (selSp2.getSelectedItem().equals("0초")){
                                            spd1 = "0";
                                            hun1 = "300";
                                        }
                                        if (selSp2.getSelectedItem().equals("1초")){
                                            spd1 = "0";
                                            hun1 = "620";
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
                        ArrayAdapter<String> sel4_9= new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, set9);
                        selSp4.setAdapter(sel4_9);
                        break;
                        //권위의 성물
                    case 10:
                        String[] set10 = {"3"};
                        selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 0 :
                                        if (selSp2.getSelectedItem().equals("0초")){
                                            spd1 = "0";
                                            hun1 = "300";
                                        }
                                        if (selSp2.getSelectedItem().equals("1초")){
                                            spd1 = "0";
                                            hun1 = "620";
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
                        ArrayAdapter<String> sel4_10= new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, set10);
                        selSp4.setAdapter(sel4_10);
                        break;
                        //풍요의 성물
                    case 11:
                        String[] set11 = {"3"};
                        selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 0 :
                                        if (selSp2.getSelectedItem().equals("0초")){
                                            spd1 = "0";
                                            hun1 = "300";
                                        }
                                        if (selSp2.getSelectedItem().equals("1초")){
                                            spd1 = "0";
                                            hun1 = "620";
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
                        ArrayAdapter<String> sel4_11= new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, set11);
                        selSp4.setAdapter(sel4_11);
                        break;
                        //유희의 성물
                    case 12:
                        String[] set12 = {"3"};
                        selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 0 :
                                        if (selSp2.getSelectedItem().equals("0초")){
                                            spd1 = "0";
                                            hun1 = "300";
                                        }
                                        if (selSp2.getSelectedItem().equals("1초")){
                                            spd1 = "0";
                                            hun1 = "620";
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
                        ArrayAdapter<String> sel4_12= new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, set12);
                        selSp4.setAdapter(sel4_12);
                        break;
                        //신들의 보물
                    case 13:
                        String[] set13 = {"4"};
                        selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 0 :
                                        if (selSp2.getSelectedItem().equals("0초")){
                                            spd1 = "0";
                                            hun1 = "420";
                                        }
                                        if (selSp2.getSelectedItem().equals("1초")){
                                            spd1 = "0";
                                            hun1 = "850";
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
                        ArrayAdapter<String> sel4_13= new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, set13);
                        selSp4.setAdapter(sel4_13);
                        break;
                        //라그나로크의 경고
                    case 14:
                        String[] set14 = {"4"};
                        selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 0 :
                                        if (selSp2.getSelectedItem().equals("0초")){
                                            spd1 = "37";
                                            hun1 = "420";
                                        }
                                        if (selSp2.getSelectedItem().equals("1초")){
                                            spd1 = "38";
                                            hun1 = "850";
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
                        ArrayAdapter<String> sel4_14= new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, set14);
                        selSp4.setAdapter(sel4_14);
                        break;
                        //고대 신화의 무기
                    case 15:
                        String[] set15 = {"4"};
                        selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position){
                                    case 0 :
                                        if (selSp2.getSelectedItem().equals("0초")){
                                            spd1 = "37";
                                            hun1 = "420";
                                        }
                                        if (selSp2.getSelectedItem().equals("1초")){
                                            spd1 = "38";
                                            hun1 = "850";
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
                        ArrayAdapter<String> sel4_15= new ArrayAdapter<String>(ResultActivity.this, R.layout.support_simple_spinner_dropdown_item, set15);
                        selSp4.setAdapter(sel4_15);
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
//6성 장비 개수 선택
    private void sel6_set(){
        selSp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                //초신성의 강림자
                case 0 :
                    String[] set6_0 = {"4","6"};
                                       selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                           @Override
                                           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                               switch (position){
                                                   case 0 :
                                                       if(selSp2.getSelectedItem().equals("0초")){
                                                           spd1 = "25";
                                                           hun1 = "0";
                                                       }
                                                       if(selSp2.getSelectedItem().equals("1초")){
                                                           spd1 = "37";
                                                           hun1 = "0";
                                                       }
                                                       if(selSp2.getSelectedItem().equals("2초")){
                                                           spd1 = "45";
                                                           hun1 = "0";
                                                       }
                                                       if(selSp2.getSelectedItem().equals("3초")){
                                                           spd1 = "46";
                                                           hun1 = "0";
                                                       }
                                                       break;
                                                   case 1 :
                                                       if(selSp2.getSelectedItem().equals("0초")){
                                                           spd1 = "25";
                                                           hun1 = "100";
                                                       }
                                                       if(selSp2.getSelectedItem().equals("1초")){
                                                           spd1 = "37";
                                                           hun1 = "300";
                                                       }
                                                       if(selSp2.getSelectedItem().equals("2초")){
                                                           spd1 = "45";
                                                           hun1 = "800";
                                                         }
                                                         if(selSp2.getSelectedItem().equals("3초")){
                                                           spd1 = "46";
                                                           hun1 = "1200";
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
                    ArrayAdapter<String> sel6_0 = new ArrayAdapter<String>(ResultActivity.this ,R.layout.support_simple_spinner_dropdown_item, set6_0);
                    selSp4.setAdapter(sel6_0);
                    break;
                    //정의의 신궁
                case 1 :
                    String[] set6_1 = {"4","6"};
                    selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            switch (position){
                                case 0 :
                                    if(selSp2.getSelectedItem().equals("0초")){
                                        spd1 = "25";
                                        hun1 = "0";
                                    }
                                    if(selSp2.getSelectedItem().equals("1초")){
                                        spd1 = "37";
                                        hun1 = "0";
                                    }
                                    if(selSp2.getSelectedItem().equals("2초")){
                                        spd1 = "45";
                                        hun1 = "0";
                                    }
                                    if(selSp2.getSelectedItem().equals("3초")){
                                        spd1 = "46";
                                        hun1 = "0";
                                    }
                                    break;
                                case 1 :
                                    if(selSp2.getSelectedItem().equals("0초")){
                                        spd1 = "25";
                                        hun1 = "100";
                                    }
                                    if(selSp2.getSelectedItem().equals("1초")){
                                        spd1 = "37";
                                        hun1 = "300";
                                    }
                                    if(selSp2.getSelectedItem().equals("2초")){
                                        spd1 = "45";
                                        hun1 = "800";
                                    }
                                    if(selSp2.getSelectedItem().equals("3초")){
                                        spd1 = "46";
                                        hun1 = "1200";
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
                    ArrayAdapter<String> sel6_1 = new ArrayAdapter<String>(ResultActivity.this ,R.layout.support_simple_spinner_dropdown_item, set6_1);
                    selSp4.setAdapter(sel6_1);
                    break;
                    //암흑군단장의 전투복
                case 2 :
                    String[] set6_2 = {"4","6"};
                    selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            switch (position){
                                case 0 :
                                    if(selSp2.getSelectedItem().equals("0초")){
                                        spd1 = "25";
                                        hun1 = "0";
                                    }
                                    if(selSp2.getSelectedItem().equals("1초")){
                                        spd1 = "37";
                                        hun1 = "0";
                                    }
                                    if(selSp2.getSelectedItem().equals("2초")){
                                        spd1 = "45";
                                        hun1 = "0";
                                    }
                                    if(selSp2.getSelectedItem().equals("3초")){
                                        spd1 = "46";
                                        hun1 = "0";
                                    }
                                    break;
                                case 1 :
                                    if(selSp2.getSelectedItem().equals("0초")){
                                        spd1 = "25";
                                        hun1 = "100";
                                    }
                                    if(selSp2.getSelectedItem().equals("1초")){
                                        spd1 = "37";
                                        hun1 = "300";
                                    }
                                    if(selSp2.getSelectedItem().equals("2초")){
                                        spd1 = "45";
                                        hun1 = "800";
                                    }
                                    if(selSp2.getSelectedItem().equals("3초")){
                                        spd1 = "46";
                                        hun1 = "1200";
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
                    ArrayAdapter<String> sel6_2 = new ArrayAdapter<String>(ResultActivity.this ,R.layout.support_simple_spinner_dropdown_item, set6_2);
                    selSp4.setAdapter(sel6_2);
                    break;
                    //빙결의 기사 무장
                case 3 :
                    String[] set6_3 = {"4","6"};
                    selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            switch (position){
                                case 0 :
                                    if(selSp2.getSelectedItem().equals("0초")){
                                        spd1 = "25";
                                        hun1 = "0";
                                    }
                                    if(selSp2.getSelectedItem().equals("1초")){
                                        spd1 = "37";
                                        hun1 = "0";
                                    }
                                    if(selSp2.getSelectedItem().equals("2초")){
                                        spd1 = "45";
                                        hun1 = "0";
                                    }
                                    if(selSp2.getSelectedItem().equals("3초")){
                                        spd1 = "46";
                                        hun1 = "0";
                                    }
                                    break;
                                case 1 :
                                    if(selSp2.getSelectedItem().equals("0초")){
                                        spd1 = "25";
                                        hun1 = "100";
                                    }
                                    if(selSp2.getSelectedItem().equals("1초")){
                                        spd1 = "37";
                                        hun1 = "300";
                                    }
                                    if(selSp2.getSelectedItem().equals("2초")){
                                        spd1 = "45";
                                        hun1 = "800";
                                    }
                                    if(selSp2.getSelectedItem().equals("3초")){
                                        spd1 = "46";
                                        hun1 = "1200";
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
                    ArrayAdapter<String> sel6_3 = new ArrayAdapter<String>(ResultActivity.this ,R.layout.support_simple_spinner_dropdown_item, set6_3);
                    selSp4.setAdapter(sel6_3);
                    break;
                    //야차왕의 무구
                case 4 :
                    String[] set6_4 = {"2","4"};
                    selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            switch (position){
                                case 0 :
                                    if(selSp2.getSelectedItem().equals("0초")){
                                        spd1 = "15";
                                        hun1 = "0";
                                    }
                                    if(selSp2.getSelectedItem().equals("1초")){
                                        spd1 = "22";
                                        hun1 = "0";
                                    }
                                    if(selSp2.getSelectedItem().equals("2초")){
                                        spd1 = "26";
                                        hun1 = "0";
                                    }
                                    if(selSp2.getSelectedItem().equals("3초")){
                                        spd1 = "27";
                                        hun1 = "0";
                                    }
                                    break;
                                case 1 :
                                    if(selSp2.getSelectedItem().equals("0초")){
                                        spd1 = "15";
                                        hun1 = "70";
                                    }
                                    if(selSp2.getSelectedItem().equals("1초")){
                                        spd1 = "22";
                                        hun1 = "210";
                                    }
                                    if(selSp2.getSelectedItem().equals("2초")){
                                        spd1 = "26";
                                        hun1 = "500";
                                    }
                                    if(selSp2.getSelectedItem().equals("3초")){
                                        spd1 = "27";
                                        hun1 = "750";
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
                    ArrayAdapter<String> sel6_4 = new ArrayAdapter<String>(ResultActivity.this ,R.layout.support_simple_spinner_dropdown_item, set6_4);
                    selSp4.setAdapter(sel6_4);
                    break;
                    //풍요의 유산
                case 5 :
                    String[] set6_5 = {"2","4"};
                    selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            switch (position){
                                case 0 :
                                    if(selSp2.getSelectedItem().equals("0초")){
                                        spd1 = "15";
                                        hun1 = "0";
                                    }
                                    if(selSp2.getSelectedItem().equals("1초")){
                                        spd1 = "22";
                                        hun1 = "0";
                                    }
                                    if(selSp2.getSelectedItem().equals("2초")){
                                        spd1 = "26";
                                        hun1 = "0";
                                    }
                                    if(selSp2.getSelectedItem().equals("3초")){
                                        spd1 = "27";
                                        hun1 = "0";
                                    }
                                    break;
                                case 1 :
                                    if(selSp2.getSelectedItem().equals("0초")){
                                        spd1 = "15";
                                        hun1 = "70";
                                    }
                                    if(selSp2.getSelectedItem().equals("1초")){
                                        spd1 = "22";
                                        hun1 = "210";
                                    }
                                    if(selSp2.getSelectedItem().equals("2초")){
                                        spd1 = "26";
                                        hun1 = "500";
                                    }
                                    if(selSp2.getSelectedItem().equals("3초")){
                                        spd1 = "27";
                                        hun1 = "750";
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
                    ArrayAdapter<String> sel6_5 = new ArrayAdapter<String>(ResultActivity.this ,R.layout.support_simple_spinner_dropdown_item, set6_5);
                    selSp4.setAdapter(sel6_5);
                    break;
                    //고대 차원수의 무장
                case 6 :
                    String[] set6_6 = {"2","4"};
                    selSp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            switch (position){
                                case 0 :
                                    if(selSp2.getSelectedItem().equals("0초")){
                                        spd1 = "0";
                                        hun1 = "30";
                                    }
                                    if(selSp2.getSelectedItem().equals("1초")){
                                        spd1 = "0";
                                        hun1 = "90";
                                    }
                                    if(selSp2.getSelectedItem().equals("2초")){
                                        spd1 = "0";
                                        hun1 = "200";
                                    }
                                    if(selSp2.getSelectedItem().equals("3초")){
                                        spd1 = "0";
                                        hun1 = "250";
                                    }
                                    break;
                                case 1 :
                                    if(selSp2.getSelectedItem().equals("0초")){
                                        spd1 = "25";
                                        hun1 = "30";
                                    }
                                    if(selSp2.getSelectedItem().equals("1초")){
                                        spd1 = "37";
                                        hun1 = "90";
                                    }
                                    if(selSp2.getSelectedItem().equals("2초")){
                                        spd1 = "45";
                                        hun1 = "200";
                                    }
                                    if(selSp2.getSelectedItem().equals("3초")){
                                        spd1 = "46";
                                        hun1 = "250";
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
                    ArrayAdapter<String> sel6_6 = new ArrayAdapter<String>(ResultActivity.this ,R.layout.support_simple_spinner_dropdown_item, set6_6);
                    selSp4.setAdapter(sel6_6);
                    break;
            }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> sel6Name_Adapter = new ArrayAdapter<String>(this ,R.layout.support_simple_spinner_dropdown_item, sp_Rank_6Name);
        selSp3.setAdapter(sel6Name_Adapter);
    }
}
