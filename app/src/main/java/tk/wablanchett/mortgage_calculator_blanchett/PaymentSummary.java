package tk.wablanchett.mortgage_calculator_blanchett;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
