package tk.wablanchett.mortgage_calculator_blanchett;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MortgageSummary extends AppCompatActivity {

    double homeValue;
    double loanAmount;
    int loanTerm;
    double interestRate;
    double propertyTax;
    double monthlyHOA;
    double insurancePerYear;
    int startMonth;
    int startYear;

    Button toDataEntry;
    Button toPaymentSummary;

    double mIns;
    double yrTx;
    double mnthFee;
    double totalMortgage;

    public double monthlyInsurance(double iPY){return (iPY/12.00);}

    public double yearlyTax(double homeValue, double propertyTax)
    {
        double decimaltax = (propertyTax / 100.00);
        return (decimaltax * homeValue);
    }

    public double feesPerMonth(double yearlyTax, double monthlyHOA, double monthlyInsurance)
    {
        return (yearlyTax + monthlyHOA + monthlyInsurance);
    }

    public double mortgageTotal(double loanAmount, double interestRate, int loanTerm)
    {
        double monthlyInterest = interestRate / 12;
        int numpayments = loanTerm * 12;

        double waypoint = (loanAmount * (monthlyInterest * (Math.pow((1 + monthlyInterest),numpayments))));
        return (waypoint / ((Math.pow((1 + monthlyInterest),numpayments)) -1 ));
    }

    public double totalMonthlyPayment(double monthlyFee, double totalMortgage, int loanTerm)
    {
        int numpayments = loanTerm * 12;
        return (monthlyFee + (totalMortgage / numpayments));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage_summary);
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
        toPaymentSummary = (Button) findViewById(R.id.paymentSummaryButton);

        toDataEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modifyValues = new Intent(MortgageSummary.this, DataEntry.class);
                modifyValues.putExtra("HV",homeValue);
                modifyValues.putExtra("LA", loanAmount);
                modifyValues.putExtra("IR",interestRate);
                modifyValues.putExtra("LT",loanTerm);
                modifyValues.putExtra("SM",startMonth);
                modifyValues.putExtra("SY", startYear);
                modifyValues.putExtra("PT", propertyTax);
                modifyValues.putExtra("IPY", insurancePerYear);
                modifyValues.putExtra("MHOA", monthlyHOA);
                MortgageSummary.this.startActivity(modifyValues);
            }
        });

        toPaymentSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent paymentSummary = new Intent(MortgageSummary.this, PaymentSummary.class);
                paymentSummary.putExtra("HV",homeValue);
                paymentSummary.putExtra("LA", loanAmount);
                paymentSummary.putExtra("IR",interestRate);
                paymentSummary.putExtra("LT",loanTerm);
                paymentSummary.putExtra("SM",startMonth);
                paymentSummary.putExtra("SY", startYear);
                paymentSummary.putExtra("PT", propertyTax);
                paymentSummary.putExtra("IPY", insurancePerYear);
                paymentSummary.putExtra("MHOA", monthlyHOA);
                MortgageSummary.this.startActivity(paymentSummary);

            }
        });







    }
}
