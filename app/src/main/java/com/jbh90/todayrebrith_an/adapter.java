package com.jbh90.todayrebrith_an;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    Context context;
    ArrayList<Post> list;
    int layout;
    int width1, heigth1;

    public adapter(Context context, ArrayList<Post> list, int layout, int width1, int heigth1) {
        this.context = context;
        this.list = list;
        this.layout = layout;
        this.width1 = width1;
        this.heigth1 = heigth1;
    }

    @NonNull
    @Override
    public adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.page1, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final adapter.ViewHolder holder, int position) {

        Post post = list.get(position);
        holder.pagLay1.setLayoutParams(new LinearLayout.LayoutParams(width1 * 4, heigth1));
        holder.pagLay2.setLayoutParams(new LinearLayout.LayoutParams(width1 * 3, heigth1));
        holder.pagLay3.setLayoutParams(new LinearLayout.LayoutParams(width1 * 3, heigth1));
        holder.pagLay4.setLayoutParams(new LinearLayout.LayoutParams(width1 * 2, heigth1));
        holder.pagLay5.setLayoutParams(new LinearLayout.LayoutParams(width1 * 3, heigth1));
        holder.txt1.setText(post.getName());

        if(post.getName().equals("(7성)일반 고대")){
            String[] num1_1 = {"0","1"};
            String[] num1_2 = {"0","2","4"};
            ArrayAdapter<String> spAdapter1_1, spAdapter1_2;
            spAdapter1_1 = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item,num1_1);
            spAdapter1_2 = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item,num1_2);
            holder.spinner1.setAdapter(spAdapter1_1);
            holder.spinner2.setAdapter(spAdapter1_2);

            if(holder.spinner1.getSelectedItem().toString().equals("0")){
                if(holder.spinner2.getSelectedItem().toString().equals("2")){
                    holder.txt2.setText("37");
                    holder.txt3.setText("0");
                }
                else if(holder.spinner2.getSelectedItem().toString().equals("4")){
                    holder.txt2.setText("37");
                    holder.txt3.setText("360");
                }
            }
            else if(holder.spinner1.getSelectedItem().toString().equals("1")){
                if(holder.spinner2.getSelectedItem().toString().equals("2")){
                    holder.txt2.setText("38");
                    holder.txt3.setText("0");
                }
                else if(holder.spinner2.getSelectedItem().toString().equals("4")){
                    holder.txt2.setText("38");
                    holder.txt3.setText("830");
                }
            }
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt1, txt2, txt3;
        Spinner spinner1, spinner2;
        LinearLayout pagLay1, pagLay2, pagLay3, pagLay4, pagLay5;
        public ViewHolder(View view) {
            super(view);
            txt1 = (TextView)view.findViewById(R.id.pageTxt1);
            txt2 = (TextView)view.findViewById(R.id.pageTxt2);
            txt3 = (TextView)view.findViewById(R.id.pageTxt3);
            spinner1 = (Spinner)view.findViewById(R.id.pageSpnner1);
            spinner2 = (Spinner)view.findViewById(R.id.pageSpnner2);
            pagLay1 = (LinearLayout)view.findViewById(R.id.pagLay1);
            pagLay2 = (LinearLayout)view.findViewById(R.id.pagLay2);
            pagLay3 = (LinearLayout)view.findViewById(R.id.pagLay3);
            pagLay4 = (LinearLayout)view.findViewById(R.id.pagLay4);
            pagLay5 = (LinearLayout)view.findViewById(R.id.pagLay5);
        }
    }

}
