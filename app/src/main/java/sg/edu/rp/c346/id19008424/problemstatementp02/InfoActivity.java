package sg.edu.rp.c346.id19008424.problemstatementp02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<DailyGrade> alDG;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        lv  = findViewById(R.id.ListViewGrades);
        alDG = new ArrayList<>();
        alDG.add(new DailyGrade("B"));
        alDG.add(new DailyGrade("C"));
        alDG.add(new DailyGrade("A"));

        aa = new GradeAdapter(this, R.layout.row, alDG);
        lv.setAdapter(aa);




    }
}
