package sg.edu.rp.c346.id19008424.problemstatementp02;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class GradeAdapter extends ArrayAdapter {

    private ArrayList<DailyGrade> grade;
    private Context context;
    private TextView tvTitle, tvGrade;
    private Button btnShare;
    

    public GradeAdapter(Context context, int resource, ArrayList<DailyGrade> objects){
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
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvTitle = rowView.findViewById(R.id.textView);
        tvGrade = rowView.findViewById(R.id.textGrade);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        DailyGrade currentGrade = grade.get(position);
        // Set the TextView to show the food
        tvTitle.setText("Week " + (position + 1));
        tvGrade.setText(currentGrade.getGrade());




        // Return the nicely done up View to the ListView
        return rowView;


    }



}
