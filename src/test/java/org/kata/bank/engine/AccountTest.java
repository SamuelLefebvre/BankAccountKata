package org.kata.bank.engine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kata.bank.constants.ActionType;
import org.kata.bank.engine.printer.LoggerPrinter;
import org.kata.bank.engine.transaction.Transaction;

import java.util.List;

import static org.kata.bank.engine.utils.GeneratorUtils.initTransaction;


/**
 * Created by salefebvre on 23/07/2016.
 */
public class AccountTest {

    private Account account;

    private LoggerPrinter loggerPrinter;

    @Before
    public void setUp(){
        loggerPrinter = new LoggerPrinter();
        account = new Account(loggerPrinter);
    }

    private void generateTransaction(Account account){
        account.withdrawal(50);
        account.deposit(100);
        account.deposit(100);
        account.deposit(100);
        account.withdrawal(25);
    }

    /**
     * Vérification de l'init d'un compte
     */
    @Test
    public void testGetAccountBalanceInit(){
        Assert.assertEquals(0,account.getStatement().getBalance(),0);
    }

    /**
     *
     */
    @Test
    public void testDeposit(){
        account.deposit(100);
        Assert.assertEquals(100,account.getStatement().getBalance(),0);
    }

    @Test
    public void testDepositTransaction(){

        Transaction transaction = initTransaction(100, ActionType.DEPOSIT);
        account.deposit(100);
        List<Transaction> transactions =  account.getStatement().getTransactionList();
        Assert.assertEquals(1,transactions.size());
        if (transactions.size()>0) {
            Assert.assertEquals(transaction,transactions.get(0));
        }
    }

    /**
     *
     */
    @Test
    public void testWithdrawal() {
        account.withdrawal(50);
        Assert.assertEquals(-50,account.getStatement().getBalance(),0);
    }

    @Test
    public void testWithdrawalTransaction(){

        Transaction transaction = initTransaction(50, ActionType.WITHDRAWAL);
        account.withdrawal(50);
        List<Transaction> transactions =  account.getStatement().getTransactionList();
        Assert.assertEquals(1,transactions.size());
        if (transactions.size()>0) {
            Assert.assertEquals(transaction,transactions.get(0));
        }
    }

    /**
     *
     */
    @Test
    public void testAccountStatementWithSeveralOperation() {
        generateTransaction(account);
        Assert.assertEquals(225,account.getStatement().getBalance(),0);
        Assert.assertEquals(5,account.getStatement().getTransactionList().size());
    }

    @Test
    public void testStatementPrinting() {
        generateTransaction(account);
        account.print();
    }
}
