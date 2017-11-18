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

import model.Debt;
import model.Loan;

/**
 * Created by student on 18/11/17.
 */

public class DebtAdapter extends BaseAdapter {

    Context context;
    ArrayList<Debt> debtList;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.row_debt_layout, parent, false);

        final TextView txtName = convertView.findViewById(R.id.txtDebtName);
        txtName.setText((debtList.get(position).getPerson().getName()));

        final TextView txtQuantity = convertView.findViewById(R.id.txtDebtQuantity);
        txtQuantity.setText(String.valueOf((debtList.get(position).getQuantity())));

        final TextView txtDate = convertView.findViewById(R.id.txtDebtDate);
        txtDate.setText((debtList.get(position).getDate().toString()));
        return convertView;
    }
}
