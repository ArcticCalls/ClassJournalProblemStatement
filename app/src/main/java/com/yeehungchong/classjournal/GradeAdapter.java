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
        // Store the food that is passed to this adapter
        grade = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.activity_info_row, parent, false);

        // Get the TextView object
        tvWeek = (TextView) rowView.findViewById(R.id.tvWeek);
        tvTitle = (TextView) rowView.findViewById(R.id.tvTitle);
        tvGrade = (TextView) rowView.findViewById(R.id.tvGrade);
        // Get the ImageView object
        ivGrade = (ImageView) rowView.findViewById(R.id.ivGrade);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        GradeInfo currentFood = grade.get(position);
        // Set the TextView to show the food

        tvWeek.setText(currentFood.getWeek());
        tvTitle.setText(currentFood.getTitle());
        tvGrade.setText(currentFood.getGrade());

        // Set the image to star or nostar accordingly
        ivGrade.setImageResource(R.drawable.dg);

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
