package org.kata.bank.engine.transaction;

import org.kata.bank.constants.ActionType;
import org.kata.bank.engine.Amount;
import org.kata.bank.constants.ConstantDate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by salefebvre on 24/07/2016.
 */
public class Transaction {

    public Transaction(Date date, Amount amount, ActionType type) {
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.balance = type.equals(ActionType.DEPOSIT)? amount.getValue(): - amount.getValue();
    }

    /**
     * Date de la transaction
     */
    private Date date;

    /**
     * Montant de la transaction
     */
    private Amount amount;

    /**
     * Balance à la suite de la transaction
     */
    private float balance;

    /**
     * Type de la transaction
     */
    private ActionType type;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    /**
     * Génère la date en string au format dd-MM-yy  hh:mm:ss
     * @return
     */
    public String getDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ConstantDate.FORMAT_DATE_DDMMYYHHMMSS);
        return simpleDateFormat.format(date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (Float.compare(that.balance, balance) != 0) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (balance != +0.0f ? Float.floatToIntBits(balance) : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
