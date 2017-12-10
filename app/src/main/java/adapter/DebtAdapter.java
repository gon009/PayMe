package adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.www.payme.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Debt;
import model.Loan;
import model.Person;

/**
 * Created by student on 18/11/17.
 */

public class DebtAdapter extends BaseAdapter {

    Context context;
    ArrayList<Debt> debtList;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

    private static LayoutInflater inflater = null;

    public DebtAdapter(Context context, ArrayList<Debt> debtList) {
        this.context = context;
        this.debtList = debtList;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return debtList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.row_debt_layout, parent, false);

        final LinearLayout loanRow = (LinearLayout)convertView.findViewById(R.id.rowDebt);

        final TextView txtName = convertView.findViewById(R.id.txtDebtName);
        txtName.setText((debtList.get(position).getPerson().getName()));

        final TextView txtQuantity = convertView.findViewById(R.id.txtDebtQuantity);
        txtQuantity.setText(String.valueOf((debtList.get(position).getQuantity())));

        final TextView txtDate = convertView.findViewById(R.id.txtDebtDate);
        txtDate.setText((dateFormat.format(debtList.get(position).getDate())));
        ImageView imgViewDelete = convertView.findViewById(R.id.imgViewDebtDelete);

        imgViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                debtList.remove(position);
                notifyDataSetChanged();
            }
        });

        loanRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_add);

                dialog.setTitle("Editar una deuda");
                dialog.show();

                final Button acceptButton = dialog.findViewById(R.id.btnAcceptLoan);
                final Button cancelButton = dialog.findViewById(R.id.btnCancelLoan);
                final EditText name = dialog.findViewById(R.id.dialogName);
                final EditText quantity = dialog.findViewById(R.id.dialogQuantity);
                final EditText date = dialog.findViewById(R.id.dialogDate);
                name.setText(debtList.get(position).getPerson().getName());
                quantity.setText(String.valueOf(debtList.get(position).getQuantity()));
                date.setText(dateFormat.format(debtList.get(position).getDate()));

                acceptButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        debtList.get(position).setPerson(new Person(name.getText().toString()));
                        debtList.get(position).setDate(new Date(date.getText().toString()));
                        debtList.get(position).setQuantity(Double.valueOf(quantity.getText().toString()));
                        dialog.dismiss();

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
        return convertView;
    }
}
