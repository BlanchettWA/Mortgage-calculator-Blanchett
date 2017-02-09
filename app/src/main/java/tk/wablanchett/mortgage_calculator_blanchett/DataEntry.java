package tk.wablanchett.mortgage_calculator_blanchett;

import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;

public class DataEntry extends AppCompatActivity {

    Button gotoPaymentSummary;
    Button gotoMortgageSummary;

    double homeValue;
    double loanAmount;
    int loanTerm;
    double interestRate;
    double propertyTax;
    double monthlyHOA;
    double insurancePerYear;

    DatePicker pickDate;
    Calendar calendar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
/**
        calendar = Calendar.getInstance();
        System.out.println("Here are some things:");
        System.out.println(calendar);
        System.out.println("------");
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println("------");
        System.out.println((calendar.get(Calendar.YEAR)) + 53);
        System.out.println("------");
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println("------");

*/




    }
}
