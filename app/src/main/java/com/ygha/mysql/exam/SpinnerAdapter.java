package com.ygha.mysql.exam;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class SpinnerAdapter extends BaseAdapter {

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }

    String items[];
    Context context;
    private int previousPosition = -1;
    private int nowPosition = 0;//-1;

    public SpinnerAdapter(String[] items, Context context) {
        this.items = items;
        this.context = context;
    }

    public void setPositionSelected(int position) {
        this.notifyDataSetChanged();
        if (previousPosition == -1)
            previousPosition = position;
        else
            previousPosition = nowPosition;

        if (nowPosition == -1)
            nowPosition = previousPosition;
        else
            nowPosition = position;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;

        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_spinner,null);
            holder = new ViewHolder();
            holder.mode = (TextView)convertView.findViewById(R.id.txt_spinner_item);
            //holder.mode.setTextColor(Color.parseColor("#6d9cff"));
            holder.mode.setTextColor(ContextCompat.getColor(context,R.color.color_white));
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.mode.setText(items[position]);

        convertView.setMinimumHeight(30);
        convertView.setBackgroundColor(Color.argb(255,50,50,50));

        convertView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setBackgroundColor(Color.argb(100,110,121,143));
                return false;
            }
        });

        if(nowPosition == position){//선택된 라인
            holder.mode.setTextColor(ContextCompat.getColor(context,R.color.color_white));
            convertView.setBackgroundColor(Color.argb(100,110,121,143));
        }

        return convertView;
    }

    static class ViewHolder{
        TextView mode;
    }


}

