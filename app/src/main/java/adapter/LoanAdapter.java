package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.www.payme.R;

import java.util.ArrayList;

import model.Loan;

/**
 * Created by student on 18/11/17.
 */

public class LoanAdapter extends BaseAdapter {

    Context context;
    ArrayList<Loan> loanList;
    private static LayoutInflater inflater = null;

    public LoanAdapter(Context context, ArrayList<Loan> loanList) {
        this.context = context;
        this.loanList = loanList;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return loanList.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.row_loan_layout, parent, false);

        final TextView txtName = convertView.findViewById(R.id.txtLoanName);
        txtName.setText((loanList.get(position).getPerson().getName()));

        final TextView txtQuantity = convertView.findViewById(R.id.txtLoanQuantity);
        txtQuantity.setText(String.valueOf((loanList.get(position).getQuantity())));

        final TextView txtDate = convertView.findViewById(R.id.txtLoanDate);
        txtDate.setText((loanList.get(position).getDate().toString()));
        return convertView;
    }
}
