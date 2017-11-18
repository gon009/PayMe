package com.example.www.payme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import adapter.DebtAdapter;
import adapter.LoanAdapter;
import model.Debt;
import model.Loan;
import model.Person;

public class DebtActivity extends AppCompatActivity {

    private ArrayList<Debt> debtList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt);
        ListView listViewLoan = (ListView)findViewById(R.id.lIstViewDebt);
        loadData();

        DebtAdapter debtAdapter = new DebtAdapter(this, debtList);
        listViewLoan.setAdapter(debtAdapter);
    }

    public void loadData()
    {
        debtList = new ArrayList<Debt>();
        debtList.add(new Debt(120 ,new Date(2016,9,10), new Person("Ricardo")));
        debtList.add(new Debt(120 ,new Date(2016,9,10), new Person("Fernando")));
        debtList.add(new Debt(111 ,new Date(2016,9,10), new Person("Maria Carmen")));
        debtList.add(new Debt(13 ,new Date(2016,9,10), new Person("Jesus")));
        debtList.add(new Debt(14 ,new Date(2016,9,10), new Person("Ximena")));
        debtList.add(new Debt(10 ,new Date(2016,9,10), new Person("Veronica")));
    }
}
