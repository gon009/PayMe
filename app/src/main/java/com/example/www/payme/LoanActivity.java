package com.example.www.payme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import adapter.LoanAdapter;
import model.Loan;
import model.Person;

public class LoanActivity extends AppCompatActivity {

    private ArrayList<Loan> loanList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);
        ListView listViewLoan = (ListView)findViewById(R.id.listViewLoan);
        loadData();

        LoanAdapter loanAdapter = new LoanAdapter(this, loanList);
        listViewLoan.setAdapter(loanAdapter);
    }

    public void loadData()
    {
        loanList = new ArrayList<Loan>();
        loanList.add(new Loan(120 ,new Date(2016,9,10), new Person("Ricardo")));
        loanList.add(new Loan(120 ,new Date(2016,9,10), new Person("Fernando")));
        loanList.add(new Loan(111 ,new Date(2016,9,10), new Person("Maria Carmen")));
        loanList.add(new Loan(13 ,new Date(2016,9,10), new Person("Jesus")));
        loanList.add(new Loan(14 ,new Date(2016,9,10), new Person("Ximena")));
        loanList.add(new Loan(10 ,new Date(2016,9,10), new Person("Veronica")));
    }

}
