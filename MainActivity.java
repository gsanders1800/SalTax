package com.example.saltax;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;
import android.util.Log;
import android.widget.*;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.*;
import android.os.*;
import android.widget.*;
import android.graphics.*;
import java.io.*;
import java.text.*;
import java.util.regex.*;





public class MainActivity extends AppCompatActivity {


String gameState;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.btnCalculate);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TextViews
                TextView Hourly = (TextView) findViewById(R.id.txtNetHourly);
                TextView Daily = (TextView) findViewById(R.id.txtNetDaily);
                TextView BiWeekly = (TextView) findViewById(R.id.txtNetBiweekly);
                TextView Monthly= (TextView) findViewById(R.id.txtNetMonthly);


            }
        });
    }

}
