package tk.wablanchett.mortgage_calculator_blanchett;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PaymentSummary extends AppCompatActivity {

    double homeValue;
    double loanAmount;
    int loanTerm;
    double interestRate;
    double propertyTax;
    double monthlyHOA;
    double insurancePerYear;
    int startMonth;
    int startYear;

    Button toMortgageSummary;
    Button toDataEntry;

    TextView numMonthlyPayments;
    TextView numBiweeklyPayment;
    TextView monthlyPayment;
    TextView biweeklyPayment;
    TextView monthlyinterest;
    TextView biweeklyinterest;
    TextView monthlyPayoff;
    TextView biweeklyPayoff;

    double totalMonthlyMortgage;
    double totalbiweeklyMortgage;

    public double mortgageTotal(double loanAmount, double interestRate, int numpayments)
    {
        double waypoint = (loanAmount * ((interestRate/12.0) * (Math.pow((1 + (interestRate/12.0)),numpayments))));
        return (waypoint / ((Math.pow((1 + (interestRate/12.0)),numpayments)) - 1 ));
    }

    public double niceFormat(double value){
        DecimalFormat format = new DecimalFormat("#.##");
        return Double.valueOf(format.format(value));
    }

    public String biweekdate(double totalMortgage, int loanTerm)
    {
        int numyears = (loanTerm*26);

        return "TO BE dETERMENED";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_summary);

        Intent transvalue = getIntent();
        homeValue = transvalue.getDoubleExtra("HV",homeValue);
        loanAmount = transvalue.getDoubleExtra("LA",loanAmount);
        interestRate = transvalue.getDoubleExtra("IR",interestRate);
        loanTerm = transvalue.getIntExtra("LT",loanTerm);
        startMonth = transvalue.getIntExtra("SM",startMonth);
        startYear = transvalue.getIntExtra("SY",startYear);
        propertyTax = transvalue.getDoubleExtra("PT",propertyTax);
        insurancePerYear = transvalue.getDoubleExtra("IPY",insurancePerYear);
        monthlyHOA = transvalue.getDoubleExtra("MHOA",monthlyHOA);

        toDataEntry = (Button) findViewById(R.id.dataEntryButton);
        toMortgageSummary = (Button) findViewById(R.id.mortgageSummaryButton);

        numMonthlyPayments = (TextView) findViewById(R.id.monthlyPaymentsBox);
        numBiweeklyPayment = (TextView) findViewById(R.id.biweeklyPaymentsBox);
        monthlyPayment = (TextView) findViewById(R.id.monthlyPaymentAmount);
        biweeklyPayment = (TextView) findViewById(R.id.biweeklyPaymentAmount);
        monthlyinterest = (TextView) findViewById(R.id.monthlyInterestBox);
        biweeklyinterest = (TextView) findViewById(R.id.biweeklyInterestBox);
        monthlyPayoff = (TextView) findViewById(R.id.monthlyPayoffDate);
        biweeklyPayoff = (TextView) findViewById(R.id.biweeklyPayoffDate);


        totalMonthlyMortgage = mortgageTotal(loanAmount,interestRate,(loanTerm*12));
        totalbiweeklyMortgage = mortgageTotal(loanAmount,interestRate,(loanTerm*26));


        numMonthlyPayments.setText(Integer.toString((loanTerm*12)) + " payments");
        numBiweeklyPayment.setText(Integer.toString((loanTerm*26)) + " payments");

        monthlyPayment.setText("Payment: $" + niceFormat((totalMonthlyMortgage/(loanTerm*12))));
        biweeklyPayment.setText("Payment: $" + niceFormat((totalbiweeklyMortgage/(loanTerm*26))));

        monthlyinterest.setText("Interest: $" + niceFormat(totalMonthlyMortgage - loanAmount));
        biweeklyinterest.setText("Interest: $" + niceFormat(totalbiweeklyMortgage - loanAmount));


        monthlyPayoff.setText("Mortgage paid by: " + Integer.toString(startMonth) + "/" + Integer.toString(startYear + loanTerm));
        biweeklyPayoff.setText("Mortgage paid by: " + biweekdate(totalbiweeklyMortgage,loanTerm));




        toDataEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modifyValues = new Intent(PaymentSummary.this, DataEntry.class);
                modifyValues.putExtra("HV",homeValue);
                modifyValues.putExtra("LA", loanAmount);
                modifyValues.putExtra("IR",interestRate);
                modifyValues.putExtra("LT",loanTerm);
                modifyValues.putExtra("SM",startMonth);
                modifyValues.putExtra("SY", startYear);
                modifyValues.putExtra("PT", propertyTax);
                modifyValues.putExtra("IPY", insurancePerYear);
                modifyValues.putExtra("MHOA", monthlyHOA);
                PaymentSummary.this.startActivity(modifyValues);
            }
        });

        toMortgageSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mortgageSummary = new Intent(PaymentSummary.this, MortgageSummary.class);
                mortgageSummary.putExtra("HV",homeValue);
                mortgageSummary.putExtra("LA", loanAmount);
                mortgageSummary.putExtra("IR",interestRate);
                mortgageSummary.putExtra("LT",loanTerm);
                mortgageSummary.putExtra("SM",startMonth);
                mortgageSummary.putExtra("SY", startYear);
                mortgageSummary.putExtra("PT", propertyTax);
                mortgageSummary.putExtra("IPY", insurancePerYear);
                mortgageSummary.putExtra("MHOA", monthlyHOA);
                PaymentSummary.this.startActivity(mortgageSummary);

            }
        });











    }
}
