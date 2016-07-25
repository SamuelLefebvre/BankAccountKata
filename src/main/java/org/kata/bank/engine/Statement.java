package org.kata.bank.engine;

import org.kata.bank.constants.ActionType;
import org.kata.bank.engine.transaction.Transaction;
import org.kata.bank.engine.transaction.TransactionService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by salefebvre on 23/07/2016.
 */
public class Statement implements TransactionService {

    public Statement(float balance) {
        this.balance = balance;
    }

    public static final int SIZE_BUFFER = 60;

    /**
     * Balance du compte
     */
    private float balance;

    /**
     * Transactions effectuées sur le compte
     */
    private List<Transaction> transactionList;

    /**
     * Enregistrement d'une transaction
     *
     * @param date
     * @param amount
     */
    @Override
    public void saveTransaction(Date date, Amount amount, ActionType type) {
        Transaction transaction = new Transaction(date, amount, type);
        transaction.setBalance(sumBalance(amount, type));
        getTransactionList().add(transaction);
    }

    /**
     * Calcul la balance à la fin de la transaction
     *
     * @param amount
     * @param type
     */
    private float sumBalance(Amount amount, ActionType type) {
        switch (type) {
            case DEPOSIT:
                this.balance = this.balance + amount.getValue();
               break;
            case WITHDRAWAL:
                this.balance = this.balance - amount.getValue();
              break;
        }
        return this.balance;
    }

    public List<Transaction> getTransactionList() {
        if (transactionList == null) {
            transactionList = new ArrayList<>();
        }
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
