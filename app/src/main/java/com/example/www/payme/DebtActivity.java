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

import adapter.DebtAdapter;
import adapter.LoanAdapter;
import model.Debt;
import model.Loan;
import model.Person;

public class DebtActivity extends AppCompatActivity {
    final Context context = this;

    private ArrayList<Debt> debtList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt);
        ListView listViewLoan = (ListView)findViewById(R.id.lIstViewDebt);
        loadData();

        final Person person = (Person)getIntent().getSerializableExtra("personDebts");

        DebtAdapter debtAdapter = new DebtAdapter(this, person.getDebtList());
        listViewLoan.setAdapter(debtAdapter);
        final Dialog dialog = new Dialog(context);


        ImageView imgViewAdd = (ImageView)findViewById(R.id.imgViewDebtAdd);
        imgViewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.dialog_add);

                dialog.setTitle("Añadir una deuda");
                dialog.show();
                final Button acceptButton = dialog.findViewById(R.id.btnAcceptLoan);
                final Button cancelButton = dialog.findViewById(R.id.btnCancelLoan);

                acceptButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final EditText name = dialog.findViewById(R.id.dialogName);
                        final EditText quantity = dialog.findViewById(R.id.dialogQuantity);
                        final EditText date = dialog.findViewById(R.id.dialogDate);
                        
                        if ((name.toString() != null && name.toString().isEmpty()) ||
                                (quantity.toString() != null && quantity.toString().isEmpty()) ||
                                (date.toString() != null && date.toString().isEmpty()))
                        {
                            person.getDebtList().add(
                                    new Debt(Double.valueOf(quantity.getText().toString()),
                                            new Date(date.getText().toString()),
                                            new Person(name.getText().toString().trim())));
                            dialog.dismiss();
                        }
                        else
                            Toast.makeText(DebtActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                       
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
        debtList = new ArrayList<Debt>();
        debtList.add(new Debt(120 ,new Date(2016,9,10), new Person("Ricardo")));
        debtList.add(new Debt(120 ,new Date(2016,9,10), new Person("Fernando")));
        debtList.add(new Debt(111 ,new Date(2016,9,10), new Person("Maria Carmen")));
        debtList.add(new Debt(13 ,new Date(2016,9,10), new Person("Jesus")));
        debtList.add(new Debt(14 ,new Date(2016,9,10), new Person("Ximena")));
        debtList.add(new Debt(10 ,new Date(2016,9,10), new Person("Veronica")));
    }
}
