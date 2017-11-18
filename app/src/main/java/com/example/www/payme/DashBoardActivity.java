package com.example.www.payme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        final Button buttonDebt = (Button) findViewById(R.id.btnDebts);
        final Button buttonLoan = (Button) findViewById(R.id.btnLoan);

        buttonDebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DebtActivity.class);
                startActivity(intent);
            }
        });

        buttonLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LoanActivity.class);
                startActivity(intent);
            }
        });
    }
}
