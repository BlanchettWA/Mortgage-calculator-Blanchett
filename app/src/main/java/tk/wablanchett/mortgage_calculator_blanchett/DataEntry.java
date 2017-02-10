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
/**
 Intent transvalue = getIntent();
 transvalue.getDoubleExtra("HV",homeValue);
 transvalue.getDoubleExtra("LA",loanAmount);
 transvalue.getDoubleExtra("IR",interestRate);
 transvalue.getIntExtra("LT",loanTerm);
 transvalue.getIntExtra("SM",startMonth);
 transvalue.getIntExtra("SY",startYear);
 transvalue.getDoubleExtra("PT",propertyTax);
 transvalue.getDoubleExtra("IPY",insurancePerYear);
 transvalue.getDoubleExtra("MHOA",monthlyHOA);

 */
        Intent restore = getIntent();

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

        System.out.println(pickDate.getMonth());
        System.out.println(pickDate.getYear());
        System.out.println("THIS WAS A TEST ______________________________");

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

        gotoMortgageSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((hVassigned && lAassigned && lTassigned && iRassign && pTassign && mHOAassign && iPYassign) == true)
                {
                    Intent mortgageSummary = new Intent(DataEntry.this, MortgageSummary.class);
                    mortgageSummary.putExtra("HV",homeValue);
                    mortgageSummary.putExtra("LA", loanAmount);
                    mortgageSummary.putExtra("IR",interestRate);
                    mortgageSummary.putExtra("LT",loanTerm);
                    mortgageSummary.putExtra("SM",(pickDate.getMonth() + 1));
                    mortgageSummary.putExtra("SY", (pickDate.getYear()));
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

                if ((hVassigned && lAassigned && lTassigned && iRassign && pTassign && mHOAassign && iPYassign) == true)
                {
                    Intent paymentSummary = new Intent(DataEntry.this, PaymentSummary.class);
                    paymentSummary.putExtra("HV",homeValue);
                    paymentSummary.putExtra("LA", loanAmount);
                    paymentSummary.putExtra("IR",interestRate);
                    paymentSummary.putExtra("LT",loanTerm);
                    paymentSummary.putExtra("SM",(pickDate.getMonth() + 1));
                    paymentSummary.putExtra("SY", (pickDate.getYear()));
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
