package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar timesTablesSeekBar=findViewById(R.id.timesTableSeekBar);
        ListView timesTablesListView=findViewById(R.id.timesTablesListView);
        timesTablesSeekBar.setMax(20);
        timesTablesSeekBar.setProgress(10);
        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int position, boolean fromUser) {
                int min=1;
                int timesTableNumber;
                if (position<min){
                   timesTableNumber=min;
                   timesTablesSeekBar.setProgress(min);
                }
                else {
                    timesTableNumber=position;
                }
                Log.i("SeekBar",Integer.toString(timesTableNumber));
                ArrayList<String> timesTableContents=new ArrayList<String>();
                for (int i=1; i<=10;i++)
                {
                    timesTableContents.add((String.valueOf(i*timesTableNumber)));
                }
                ArrayAdapter arrayAdapter=new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,timesTableContents);
                timesTablesListView.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}