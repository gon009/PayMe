package com.example.www.payme;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import adapter.LoanAdapter;
import model.Loan;
import model.Person;

public class LoanActivity extends AppCompatActivity {

    final Context context = this;
    private ArrayList<Loan> loanList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);
        ListView listViewLoan = (ListView)findViewById(R.id.listViewLoan);
        loadData();

        LoanAdapter loanAdapter = new LoanAdapter(this, loanList);
        listViewLoan.setAdapter(loanAdapter);
        final Dialog dialog = new Dialog(context);


        ImageView imgViewAdd = (ImageView)findViewById(R.id.imgViewLoanAdd);
        imgViewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.dialog_add);

                dialog.setTitle("Añadir un prestamo");
                dialog.show();
                final Button acceptButton = dialog.findViewById(R.id.btnAcceptLoan);
                final Button cancelButton = dialog.findViewById(R.id.btnCancelLoan);

                acceptButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final EditText name = dialog.findViewById(R.id.dialogName);
                        final EditText quantity = dialog.findViewById(R.id.dialogQuantity);
                        final EditText date = dialog.findViewById(R.id.dialogDate);

                        if ((name.toString().trim() != null && name.toString().trim().isEmpty()) ||
                                (quantity.toString().trim() != null && quantity.toString().trim().isEmpty()) ||
                                (date.toString().trim() != null && date.toString().trim().isEmpty()))
                        {
                            loanList.add(
                                    new Loan(Double.valueOf(quantity.getText().toString()),
                                    new Date(date.getText().toString()),
                                    new Person(name.getText().toString().trim())));
                            dialog.dismiss();
                        }
                        else
                            Toast.makeText(LoanActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                    }
                });

                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });

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
