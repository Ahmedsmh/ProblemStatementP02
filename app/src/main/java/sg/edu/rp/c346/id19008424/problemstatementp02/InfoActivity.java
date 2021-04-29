package sg.edu.rp.c346.id19008424.problemstatementp02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<DailyGrade> alDG;
    ArrayAdapter aa;
    Button btnEmail, btnAdd, btnInfo;

    int addButton = 1;
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
        btnEmail = findViewById(R.id.buttonEmail);
        btnInfo = findViewById(R.id.buttonInfo);
        btnAdd = findViewById(R.id.buttonAdd);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                String grade = "";
                for (int i = 0; i < alDG.size(); i++){
                    grade += "Week " + (i+1) +": DG:" + alDG.get(i).getGrade() + "\n";
                }
                email.putExtra(Intent.EXTRA_TEXT,"Hi faci, \n I am... \n Please see my remarks so far, thank you! \n" + grade);
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(InfoActivity.this, AddDG.class);
                intent.putExtra("week", "" + (alDG.size()+1));
                startActivityForResult(intent, addButton);
            }
        });


    }

        @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Only hande when 2nd activity closed normally
        //  and data contalins something
        if(resultCode == RESULT_OK){
            if(data != null){
                // Get data passed back from 2nd activity
                String grade = data.getStringExtra("grade");
                String statement = "";
               // Toast.makeText(InfoActivity.this, grade, Toast.LENGTH_LONG).show();
                alDG.add(new DailyGrade(grade));
                aa.notifyDataSetChanged();
            }
        }
    }
}

