package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 18/11/17.
 */

public class Person {
    private String Name;
    private List<Debt> DebtList;
    private List<Loan> LoanList;

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

    public List<Debt> getDebtList() {
        return DebtList;
    }

    public void setDebtList(List<Debt> debtList) {
        DebtList = debtList;
    }

    public List<Loan> getLoanList() {
        return LoanList;
    }

    public void setLoanList(List<Loan> loanList) {
        LoanList = loanList;
    }
}
