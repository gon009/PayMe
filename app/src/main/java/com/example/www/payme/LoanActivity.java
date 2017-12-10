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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);
        ListView listViewLoan = (ListView)findViewById(R.id.listViewLoan);

        final Person person = (Person)getIntent().getSerializableExtra("personLoans");

        final LoanAdapter loanAdapter = new LoanAdapter(this, person.getLoanList());
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

                        if ((name.toString()!= null && !name.toString().isEmpty()) ||
                                (quantity.toString() != null && !quantity.toString().isEmpty()) ||
                                (date.toString() != null && !date.toString().isEmpty()))
                        {
                            person.getLoanList().add(
                                    new Loan(Double.valueOf(quantity.getText().toString()),
                                    new Date(date.getText().toString()),
                                    new Person(name.getText().toString())));
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
}
