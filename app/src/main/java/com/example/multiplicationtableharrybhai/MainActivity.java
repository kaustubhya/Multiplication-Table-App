package com.example.multiplicationtableharrybhai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ListView listView;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.tableListView);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setMax(20);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(MainActivity.this, "Populating table of " + i, Toast.LENGTH_SHORT).show();
                populate(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void populate (int table){

        ArrayList<String> multiplicationTable = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            multiplicationTable.add(table + " X " + i + " = " + table * i );
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,multiplicationTable);
        listView.setAdapter(arrayAdapter);
        textView.setText("Multiplication Table of " + table);


    }
}