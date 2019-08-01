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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.btnCalculate);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Items in main activity
                TextView Hourly = (TextView) findViewById(R.id.txtNetHourly);
                TextView Daily = (TextView) findViewById(R.id.txtNetDaily);
                TextView BiWeekly = (TextView) findViewById(R.id.txtNetBiweekly);
                TextView Monthly = (TextView) findViewById(R.id.txtNetMonthly);
                EditText State = (EditText) findViewById(R.id.txtState);
                EditText GrossSal = (EditText) findViewById(R.id.txtSalary);
                RadioButton Single = (RadioButton) findViewById(R.id.RbtnSingle);
                RadioButton HeadOfHouse = (RadioButton) findViewById(R.id.RbtnHeadOfHousehold);
                RadioButton Married = (RadioButton) findViewById(R.id.RbtnMarried);
                TextView Warn = (TextView) findViewById(R.id.lblWarning);

                //Variables
                double GrossSalary;
                double NetSalary, NetMonthly, NetBiWeekly, NetDaily, NetHourly;
                double FedTaxRate, StateTaxRate, SSRate, MedicareRate;
                String StateName, MaritalStat, Salary;

                //Get Salary from individual and convert to double
                Salary = GrossSal.toString();
                GrossSalary =  Double.parseDouble(Salary);

                //Get name of the stat & deny invalid entry (MUST CONTINUE)
                StateName = State.toString();



                //Get Marital Status
                if(Single.isChecked()) {
                    MaritalStat = "Single";
                }
                else if(HeadOfHouse.isChecked()) {
                    MaritalStat = "Head Of Household";
                }
                else if(Married.isChecked()){
                    MaritalStat = "Married";
                }
                else{
                    Warn.setVisibility(View.VISIBLE);
                    Warn.setText("Warning: Please select a marital Status");
                }

                //Determine what bracket the individual is in with salary range
                if(GrossSalary > 0 && GrossSalary <= 9525){

                }

                //New Jersey State Tax
                if(StateName == "NJ" || StateName == "nj"){

                }


            }
        });
    }

}
