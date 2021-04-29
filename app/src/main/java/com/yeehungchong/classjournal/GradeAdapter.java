package com.yeehungchong.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GradeAdapter extends ArrayAdapter<GradeInfo> {

    private ArrayList<GradeInfo> grade;
    private Context context;
    private ImageView ivGrade;
    private TextView tvWeek, tvTitle, tvGrade;

    public GradeAdapter(Context context, int resource, ArrayList<GradeInfo> objects){
        super(context, resource, objects);
        grade = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_info_row, parent, false);

        tvWeek = rowView.findViewById(R.id.tvWeek);
        tvTitle = rowView.findViewById(R.id.tvTitle);
        tvGrade = rowView.findViewById(R.id.tvGrade);
        ivGrade = rowView.findViewById(R.id.ivGrade);

        GradeInfo currentGrade = grade.get(position);

        tvWeek.setText("Week" + currentGrade.getWeek());
        tvTitle.setText(currentGrade.getTitle());
        tvGrade.setText(currentGrade.getGrade());

        ivGrade.setImageResource(R.drawable.dg);

        return rowView;
    }
}
