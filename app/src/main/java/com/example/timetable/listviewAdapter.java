package com.example.timetable;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class listviewAdapter extends BaseAdapter {

    public ArrayList<Model> productList;
    Activity activity;

    public listviewAdapter(Activity activity, ArrayList<Model> productList) {
        super();
        this.activity = activity;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView mSNo;
        TextView mone;
        TextView mtwo;
        TextView mthree;
        TextView mfour;
        TextView mfive;
        TextView msix;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_row, null);
            holder = new ViewHolder();
            holder.mSNo = (TextView) convertView.findViewById(R.id.sNo);
            holder.mone = (TextView) convertView.findViewById(R.id.product);
            holder.mtwo = (TextView) convertView
                    .findViewById(R.id.category);
            holder.mthree = (TextView) convertView.findViewById(R.id.price);
            holder.mfour = (TextView) convertView.findViewById(R.id.four);
            holder.mfive = (TextView) convertView
                    .findViewById(R.id.five);
            holder.msix = (TextView) convertView.findViewById(R.id.six);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Model item = productList.get(position);
        holder.mSNo.setText(item.getSno().toString());
        holder.mone.setText(item.getone().toString());
        holder.mtwo.setText(item.gettwo().toString());
        holder.mthree.setText(item.getthree().toString());
        holder.mfour.setText(item.getfour().toString());
        holder.mfive.setText(item.getfive().toString());
        holder.msix.setText(item.getsix().toString());

        return convertView;
    }
}