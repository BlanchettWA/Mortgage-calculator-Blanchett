package tk.wablanchett.mortgage_calculator_blanchett;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage_summary);
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







    }
}
