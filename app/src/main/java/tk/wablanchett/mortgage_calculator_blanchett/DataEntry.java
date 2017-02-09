package tk.wablanchett.mortgage_calculator_blanchett;

import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class DataEntry extends AppCompatActivity {

    Button gotoPaymentSummary;
    Button gotoMortgageSummary;

    double homeValue;
    EditText hVEdit;
    boolean hVassigned = false;

    double loanAmount;
    EditText lAEdit;
    boolean lAassigned = false;

    int loanTerm;
    EditText lTEdit;
    boolean lTassigned = false;

    double interestRate;
    EditText iREdit;
    boolean iRassign = false;

    double propertyTax;
    EditText pTEdit;
    boolean pTassign = false;

    double monthlyHOA;
    EditText mHOWEdit;
    boolean mHOAassign = false;

    double insurancePerYear;
    EditText iPYEdit;
    boolean iPYassign = false;


    DatePicker pickDate;
    Calendar calendar;
    TextView startDate;

public void upDateLabel(){
    if (lTassigned){
        startDate.setText((calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR) + " to " + (calendar.get(Calendar.MONTH) + 1) + "/" + (calendar.get(Calendar.YEAR) + loanTerm));
    }
    else
    {
        startDate.setText((calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR) + " to...");
    }

}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);

        startDate = (TextView) findViewById(R.id.startDateLabel);
        calendar = Calendar.getInstance();
        pickDate = (DatePicker) findViewById(R.id.datePicker);
        upDateLabel();
        pickDate.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(year, monthOfYear, dayOfMonth);
                upDateLabel();
            }
        });


        hVEdit = (EditText) findViewById(R.id.homeValue);
        hVEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() > 0)
                {homeValue = Double.valueOf(s.toString()); hVassigned = true;}
                else{hVassigned = false; homeValue = 0;}

                System.out.print("Set the value to ");
                System.out.println(homeValue + "and" + hVassigned);
            }
        });

        lAEdit = (EditText) findViewById(R.id.loanAmount);
        lAEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {loanAmount = Double.valueOf(s.toString()); lAassigned = true;}
                else{lAassigned = false;loanAmount = 0;}

                System.out.print("Set the value to ");
                System.out.println(loanAmount + "and" + lAassigned);
            }


        });

        lTEdit = (EditText) findViewById(R.id.loanTerm);
        lTEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                if (s.length() > 0){
                    loanTerm = Integer.valueOf(s.toString());
                    lTassigned = true;
                    upDateLabel();
                }
                else{
                    loanTerm = 0;
                    lTassigned = false;
                    upDateLabel();
                }

                System.out.print("Set the value to ");
                System.out.println(loanTerm + "and" + lTassigned);

            }
        });


        iREdit = (EditText) findViewById(R.id.interestRate);
        iREdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) { if (s.length() > 0){
                interestRate = Double.valueOf(s.toString());
                iRassign = true;
            }
                else{iRassign = false; interestRate = 0;}

                System.out.print("Set the value to ");
                System.out.println(interestRate + "and" + iRassign);
            }
        });

        pTEdit = (EditText) findViewById(R.id.propertyTax);
        pTEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() > 0){
                    propertyTax = Double.valueOf(s.toString());
                    pTassign = true;
                }
                else{pTassign = false; propertyTax = 0;}

                System.out.print("Set the value to ");
                System.out.println(propertyTax + "and" + pTassign);
            }
        });

        mHOWEdit = (EditText) findViewById(R.id.monthlyHOA);
        mHOWEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {monthlyHOA = Double.valueOf(s.toString()); mHOAassign = true;}
                else{mHOAassign = false; monthlyHOA = 0;}

                System.out.print("Set the value to ");
                System.out.println(monthlyHOA + "and" + mHOAassign);
            }
        });


        iPYEdit = (EditText) findViewById(R.id.insurancePerYear);
        iPYEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            if (s.length() > 0){ insurancePerYear = Double.valueOf(s.toString()); iPYassign = true;}
                else{insurancePerYear = 0; iPYassign = false;}

                System.out.print("Set the value to ");
                System.out.println(insurancePerYear + "and" + iPYassign);
            }
        });




    }
}
