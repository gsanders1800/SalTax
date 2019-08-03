package com.example.saltax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class MainActivity extends AppCompatActivity {
    public void MaritalStatus(String M, double FT, double GS, double FSD){
        //Determine what bracket the individual is in with salary range for Fed Tax and Determine Standard Deduction (Single, Head Of Household, Married)
        while (M == "Single" || M == "single") {
            if (GS > 0 && GS <= 9700) {
                FT = .10;
            } else if (GS > 9700 && GS <= 39475) {
                FT = .12;
            } else if (GS > 39475 && GS <= 84200) {
                FT = .22;
            } else if (GS > 84200 && GS <= 160725) {
                FT = .24;
            } else if (GS > 160725 && GS <= 204100) {
                FT = .32;
            } else if (GS > 204100 && GS <= 510300) {
                FT = .35;
            } else {
                FT = .37;
            }
            FSD = 12200;
            break;
        }
        if (M == "head of household" || M == "hoh") {
            if (GS > 0 && GS <= 13850) {
                FT = .10;
            } else if (GS > 13850 && GS <= 52850) {
                FT = .12;
            } else if (GS > 52850 && GS <= 84200) {
                FT = .22;
            } else if (GS > 84200 && GS <= 160700) {
                FT = .24;
            } else if (GS > 160700 && GS <= 204100) {
                FT = .32;
            } else if (GS > 204100 && GS <= 510300) {
                FT = .35;
            } else {
                FT = .37;
            }
            FSD = 18350;

        }
        if(M == "Married" || M == "married") {
            if (GS > 0 && GS <= 19400) {
                FT = .10;
            } else if (GS > 19400 && GS <= 78950) {
                FT = .12;
            } else if (GS > 78950 && GS <= 168400) {
                FT = .22;
            } else if (GS > 168400 && GS <= 321450) {
                FT = .24;
            } else if (GS > 321450 && GS <= 408200) {
                FT = .32;
            } else if (GS > 408200 && GS <= 612350) {
                FT = .35;
            } else {
                FT = .37;
            }

            FSD = 24400;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.btnCalculate);



        button.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            //Items in main activity
            TextView Hourly = (TextView) findViewById(R.id.txtNetHourly);
            TextView Daily = (TextView) findViewById(R.id.txtNetDaily);
            TextView BiWeekly = (TextView) findViewById(R.id.txtNetBiweekly);
            TextView Monthly = (TextView) findViewById(R.id.txtNetMonthly);
            EditText State = (EditText) findViewById(R.id.txtState);
            EditText GrossSal = (EditText) findViewById(R.id.txtSalary);
            EditText Marital = (EditText) findViewById(R.id.txtMaritalStat);
            TextView Warn = (TextView) findViewById(R.id.lblWarning);

            //Variables
            double GrossSalary;
            double FedStandardDeduction19 = 0, StateStandardDeduction19;
            double NetSalary, NetMonthly, NetBiWeekly, NetDaily, NetHourly;
            double FedTaxRate = 0, StateTaxRate = 0;
            double FICARate = .0765;
            double FedTax, StateTax, FICATax;
            double TotalTax;
            String StateName, MaritalStat, Salary, SHourly, SDaily, SBiWeekly, SMonthly;

            //Get Salary from individual and convert to double
            Salary = GrossSal.toString();
            GrossSalary = Double.valueOf(Salary);

            //Get name of the state
            StateName = State.toString();

            //Get Marital Status
            MaritalStat = Marital.toString();

            //New Jersey State Tax
            if (StateName == "NJ" || StateName == "nj") {
                //NJ Tax Table
                if (MaritalStat == "Single" || MaritalStat == "single") {
                    if (GrossSalary > 0 || GrossSalary <= 20000) {
                        StateTaxRate = .014;
                    } else if (GrossSalary > 20000 || GrossSalary <= 35000) {
                        StateTaxRate = .0175;
                    } else if (GrossSalary > 35000 || GrossSalary <= 40000) {
                        StateTaxRate = .035;
                    } else if (GrossSalary > 40000 || GrossSalary <= 75000) {
                        StateTaxRate = .05525;
                    } else if (GrossSalary > 75000 || GrossSalary <= 500000) {
                        StateTaxRate = .0637;
                    } else {
                        StateTaxRate = .0897;
                    }

                }
                if (MaritalStat == "head of household" || MaritalStat == "hoh") {
                    if (GrossSalary > 0 || GrossSalary <= 20000) {
                        StateTaxRate = .014;
                    } else if (GrossSalary > 20000 || GrossSalary <= 35000) {
                        StateTaxRate = .0175;
                    } else if (GrossSalary > 35000 || GrossSalary <= 40000) {
                        StateTaxRate = .035;
                    } else if (GrossSalary > 40000 || GrossSalary <= 75000) {
                        StateTaxRate = .05525;
                    } else if (GrossSalary > 75000 || GrossSalary <= 500000) {
                        StateTaxRate = .0637;
                    } else {
                        StateTaxRate = .0897;
                    }

                }
                if (MaritalStat == "Married" || MaritalStat == "married") {
                    if (GrossSalary > 0 || GrossSalary <= 20000) {
                        StateTaxRate = .014;
                    } else if (GrossSalary > 20000 || GrossSalary <= 50000) {
                        StateTaxRate = .0175;
                    } else if (GrossSalary > 50000 || GrossSalary <= 70000) {
                        StateTaxRate = .0245;
                    } else if (GrossSalary > 70000 || GrossSalary <= 80000) {
                        StateTaxRate = .035;
                    } else if (GrossSalary > 80000 || GrossSalary <= 150000) {
                        StateTaxRate = .05525;
                    } else if (GrossSalary > 150000 || GrossSalary <= 500000) {
                        StateTaxRate = .0637;
                    } else {
                        StateTaxRate = .0897;
                    }

                }

            }

            //State Standard Deduction
            StateStandardDeduction19 = 1000;

            //Get Fed, State and FICA taxes and add them up
            FedTax = FedTaxRate * GrossSalary;
            StateTax = StateTaxRate * GrossSalary;
            FICATax = FICARate * GrossSalary;

            TotalTax = FedTax + StateTax + FICATax + FedStandardDeduction19 + StateStandardDeduction19;

            //Subtract GrossSalary from TotalTax
            NetSalary = GrossSalary - TotalTax;

            //Get hourly, daily, biweekly, monthly from annual salary and convert double to string
            NetHourly = NetSalary / 2080;
            SHourly = String.valueOf(NetHourly);

            NetDaily = NetHourly * 8;
            SDaily = String.valueOf(NetDaily);

            NetBiWeekly = NetDaily * 10;
            SBiWeekly = String.valueOf(NetBiWeekly);

            NetMonthly = NetBiWeekly * 2;
            SMonthly = String.valueOf(NetMonthly);

            //Put variables on application
            Hourly.setText(SHourly);
            Daily.setText(SDaily);
            BiWeekly.setText(SBiWeekly);
            Monthly.setText(SMonthly);
        }


      });

    }
}
