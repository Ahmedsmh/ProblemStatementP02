package sg.edu.rp.c346.id19008424.problemstatementp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModule;
    ArrayAdapter aa;
    ArrayList<String> modules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModule = (ListView) findViewById(R.id.listViewModule);
        modules = new ArrayList<String>();
        modules.add("C347");
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, modules);
        lvModule.setAdapter(aa);

        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =  new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("holiday", modules.get(position));
                startActivity(intent);
            }
        });

    }
}
