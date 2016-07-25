package org.kata.bank.engine;

import org.kata.bank.constants.ActionType;
import org.kata.bank.engine.printer.Printer;

import java.util.Calendar;

/**
 * Created by salefebvre on 23/07/2016.
 */
public class Account {

    private static final float INITIAL_BALANCE = 0;

    public Account(Printer printer){
        this.statement = new Statement(INITIAL_BALANCE);
        this.printer = printer;
    }
    /**
     *
     */
    private Statement statement;

    /**
     *
     */
    private final Printer printer;



    /**
     * depot sur un compte
     * @param value
     *
     */
    public void deposit(float value) {
        Amount amount = new Amount(value);
        statement.saveTransaction(Calendar.getInstance().getTime(),amount, ActionType.DEPOSIT);
    }

    /**
     *  retrait sur un compte
     * @param value
     *
     */
    public void withdrawal(float value) {
        Amount amount = new Amount(value);
        statement.saveTransaction(Calendar.getInstance().getTime(),amount,ActionType.WITHDRAWAL);
    }

    /**
     * Impression des informations du compte
     */
    public void print(){
      if( printer != null) {
          printer.print(statement);
      }
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

}
