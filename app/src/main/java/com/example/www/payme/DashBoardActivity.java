package com.example.www.payme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import model.Debt;
import model.Loan;
import model.Person;

public class DashBoardActivity extends AppCompatActivity {

    Person person;
    ArrayList<Debt> debtList;
    ArrayList<Loan> loanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        final Button buttonDebt = (Button) findViewById(R.id.btnDebts);
        final Button buttonLoan = (Button) findViewById(R.id.btnLoan);

        person = new Person("Goncito");
        loadData();
        person.setLoanList(loanList);
        person.setDebtList(debtList);

        TextView txtWelcome = (TextView)findViewById(R.id.txtViewWelcome);
        txtWelcome.setText("Bievenido "+ person.getName());

        buttonDebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DebtActivity.class);
                intent.putExtra("personDebts", person);

                startActivity(intent);
            }
        });

        buttonLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LoanActivity.class);
                intent.putExtra("personLoans", person);
                startActivity(intent);
            }
        });
        Toast.makeText(this, "ON CREATE", Toast.LENGTH_SHORT).show();
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

        loanList = new ArrayList<Loan>();
        loanList.add(new Loan(120 ,new Date(2016,9,10), new Person("Ricardo")));
        loanList.add(new Loan(120 ,new Date(2016,9,10), new Person("Fernando")));
        loanList.add(new Loan(111 ,new Date(2016,9,10), new Person("Maria Carmen")));
        loanList.add(new Loan(13 ,new Date(2016,9,10), new Person("Jesus")));
        loanList.add(new Loan(14 ,new Date(2016,9,10), new Person("Ximena")));
        loanList.add(new Loan(10 ,new Date(2016,9,10), new Person("Veronica")));
    }
}
