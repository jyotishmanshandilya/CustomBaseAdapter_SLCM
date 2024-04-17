package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {

    ArrayList<String> SubjectList;
    ArrayList<String> SubjectMarksList;
    Context context;
    LayoutInflater inflater;
    public CustomListAdapter(Context ctx, ArrayList<String> SubjectList, ArrayList<String> SubjectMarksList){
        this.context = ctx;
        this.SubjectList = SubjectList;
        this.SubjectMarksList = SubjectMarksList;
        inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return SubjectList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_list_view, null);
        TextView subject = (TextView) convertView.findViewById(R.id.textView2);
        TextView marks = (TextView) convertView.findViewById(R.id.textView3);
        subject.setText(SubjectList.get(position));
        marks.setText(SubjectMarksList.get(position));
        return convertView;
    }
    public void addSubject(String subject, String marks){
        SubjectList.add(subject);
        SubjectMarksList.add(marks);
        notifyDataSetChanged();
    }
}
