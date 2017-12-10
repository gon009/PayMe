package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 18/11/17.
 */

public class Person implements Serializable{
    private String Name;
    private ArrayList<Debt> DebtList;
    private ArrayList<Loan> LoanList;

    public Person(String name){
        Name = name;
        LoanList = new ArrayList<>();
        DebtList = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Debt> getDebtList() {
        return DebtList;
    }

    public void setDebtList(ArrayList<Debt> debtList) {
        DebtList = debtList;
    }

    public ArrayList<Loan> getLoanList() {
        return LoanList;
    }

    public void setLoanList(ArrayList<Loan> loanList) {
        LoanList = loanList;
    }
}
