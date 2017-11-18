package model;

import java.util.Date;

/**
 * Created by student on 18/11/17.
 */

public class Loan {
    private double Quantity;
    private Date Date;
    private Person Person;

    public Loan(double quantity, Date date, Person person){
        Quantity = quantity;
        Date = date;
        Person = person;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public model.Person getPerson() {
        return Person;
    }

    public void setPerson(model.Person person) {
        Person = person;
    }
}
