package sg.edu.rp.c346.id19008424.problemstatementp02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AddDG extends AppCompatActivity {

    TextView tvWeek, tvDG;
    Button btnSubmit;
    RadioButton radioButtonGrade;
    RadioGroup radioGroup;
    int getRequestCodeForGrade = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_d_g);

        tvDG = (TextView) findViewById(R.id.textViewDG);
        tvWeek = (TextView) findViewById(R.id.textViewWeek);
        btnSubmit = (Button) findViewById(R.id.buttonSubmit);

       radioGroup = (RadioGroup) findViewById(R.id.gradeGroup);

//        int selectedId = radioGroup.getCheckedRadioButtonId();
//
//        radioButtonGrade = (RadioButton) findViewById(selectedId);
//        String gradeSelected = radioButtonGrade.getText().toString();



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId != -1){
                    radioButtonGrade = (RadioButton) findViewById(selectedId);
                    String selectedGrade = radioButtonGrade.getText().toString();
                    Intent i = new Intent();


                    i.putExtra("grade", selectedGrade);
//                    DailyGrade newGrade = new DailyGrade(selectedGrade);
                    setResult(RESULT_OK, i);
//                    Toast.makeText(AddDG.this, selectedGrade, Toast.LENGTH_LONG).show();
                    finish();

                } else {
                    Toast.makeText(AddDG.this, "Nothing selected", Toast.LENGTH_LONG).show();
                }
            }
        });

}

}