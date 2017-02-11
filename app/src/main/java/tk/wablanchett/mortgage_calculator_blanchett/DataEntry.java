package tk.wablanchett.mortgage_calculator_blanchett;

import android.content.Intent;
import android.icu.util.Calendar;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    int startMonth;
    int startYear;

public void upDateLabel(){
    if (lTassigned){
        startDate.setText(startMonth + "/" + calendar.get(Calendar.YEAR) + " to " + startMonth + "/" + (calendar.get(Calendar.YEAR) + loanTerm));
    }
    else
    {
        startDate.setText(startMonth + "/" + calendar.get(Calendar.YEAR) + " to...");
    }

}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);

        gotoMortgageSummary = (Button) findViewById(R.id.mortgageSummaryButton);
        gotoPaymentSummary = (Button) findViewById(R.id.paymentSummaryButton);

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
                {homeValue = Double.valueOf(("0" + s.toString())); hVassigned = true;}
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
                if (s.length() > 0) {loanAmount = Double.valueOf(("0" + s.toString())); lAassigned = true;}
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
                interestRate = Double.valueOf(("0" + s.toString()));
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
                    propertyTax = Double.valueOf(("0" + s.toString()));
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
                if (s.length() > 0) {monthlyHOA = Double.valueOf(("0" + s.toString())); mHOAassign = true;}
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
                if (s.length() > 0){ insurancePerYear = Double.valueOf(("0" + s.toString())); iPYassign = true;}
                else{insurancePerYear = 0; iPYassign = false;}

                System.out.print("Set the value to ");
                System.out.println(insurancePerYear + "and" + iPYassign);
            }
        });

        startDate = (TextView) findViewById(R.id.startDateLabel);
        calendar = Calendar.getInstance();
        pickDate = (DatePicker) findViewById(R.id.datePicker);


        Intent restore = getIntent();

        if (restore.hasExtra("HV")){
            homeValue = restore.getDoubleExtra("HV",homeValue);
            hVassigned = true;
            hVEdit.setText(Double.toString(homeValue));
        }

        if (restore.hasExtra("LA")){
            loanAmount = restore.getDoubleExtra("LA",loanAmount);
            lAassigned = true;
            lAEdit.setText(Double.toString(loanAmount));
        }

        if (restore.hasExtra("IR")){
            interestRate = restore.getDoubleExtra("IR",interestRate);
            iRassign = true;
            iREdit.setText(Double.toString(interestRate));
        }

        if (restore.hasExtra("LT")){
            loanTerm = restore.getIntExtra("LT",loanTerm);
            lTassigned = true;
            lTEdit.setText(Integer.toString(loanTerm));
        }

        if (restore.hasExtra("SM") && restore.hasExtra("SY")){

            startMonth = restore.getIntExtra("SM",startMonth);
            startYear = restore.getIntExtra("SY",startYear);
            pickDate.init(startYear, (startMonth - 1), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    startMonth = (monthOfYear + 1);
                    startYear = year;
                    calendar.set(startYear,(startMonth - 1),dayOfMonth);
                    upDateLabel();
                }
            });

        }
        else
        {
            startMonth = (calendar.get(Calendar.MONTH) + 1);
            startYear = calendar.get(Calendar.YEAR);
            pickDate.init(startYear, (startMonth - 1), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    startMonth = (monthOfYear + 1);
                    startYear = year;
                    calendar.set(startYear,(startMonth - 1),dayOfMonth);
                    upDateLabel();
                }
            });

        }

        if (restore.hasExtra("PT"))
        {
            propertyTax = restore.getDoubleExtra("PT",propertyTax);
            pTassign = true;
            pTEdit.setText(Double.toString(propertyTax));

        }

        if (restore.hasExtra("IPY")){
            insurancePerYear = restore.getDoubleExtra("IPY",insurancePerYear);
            iPYassign = true;
            iPYEdit.setText(Double.toString(insurancePerYear));
        }

        if (restore.hasExtra("MHOA")){
          monthlyHOA = restore.getDoubleExtra("MHOA",monthlyHOA);
            mHOAassign = true;
            mHOWEdit.setText(Double.toString(monthlyHOA));
        }

        gotoMortgageSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (hVassigned && lAassigned && lTassigned && iRassign && pTassign && mHOAassign && iPYassign)
                {
                    Intent mortgageSummary = new Intent(DataEntry.this, MortgageSummary.class);
                    mortgageSummary.putExtra("HV",homeValue);
                    mortgageSummary.putExtra("LA", loanAmount);
                    mortgageSummary.putExtra("IR",interestRate);
                    mortgageSummary.putExtra("LT",loanTerm);
                    mortgageSummary.putExtra("SM",startMonth);
                    mortgageSummary.putExtra("SY", startYear);
                    mortgageSummary.putExtra("PT", propertyTax);
                    mortgageSummary.putExtra("IPY", insurancePerYear);
                    mortgageSummary.putExtra("MHOA", monthlyHOA);
                    DataEntry.this.startActivity(mortgageSummary);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please provide all values",Toast.LENGTH_LONG).show();
                }


            }
        });

        gotoPaymentSummary.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if (hVassigned && lAassigned && lTassigned && iRassign && pTassign && mHOAassign && iPYassign)
                {
                    Intent paymentSummary = new Intent(DataEntry.this, PaymentSummary.class);
                    paymentSummary.putExtra("HV",homeValue);
                    paymentSummary.putExtra("LA", loanAmount);
                    paymentSummary.putExtra("IR",interestRate);
                    paymentSummary.putExtra("LT",loanTerm);
                    paymentSummary.putExtra("SM", startMonth);
                    paymentSummary.putExtra("SY", startYear);
                    paymentSummary.putExtra("PT", propertyTax);
                    paymentSummary.putExtra("IPY", insurancePerYear);
                    paymentSummary.putExtra("MHOA", monthlyHOA);
                    DataEntry.this.startActivity(paymentSummary);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please provide all values",Toast.LENGTH_LONG).show();
                }
            }
        }

        );



    } //end of onCreate



} //end of class
