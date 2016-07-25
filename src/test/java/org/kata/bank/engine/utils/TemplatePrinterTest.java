package org.kata.bank.engine.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kata.bank.constants.ActionType;
import org.kata.bank.constants.ConstantPrinter;
import org.kata.bank.constants.ConstantSeparator;
import org.kata.bank.engine.transaction.Transaction;
import org.kata.bank.utils.TemplatePrinter;

import static org.kata.bank.engine.utils.GeneratorUtils.initTransaction;

/**
 * Created by salefebvre on 24/07/2016.
 */
public class TemplatePrinterTest {

    private Transaction transactionWithdrawal;

    private Transaction transactionDeposit;

    @Before
    public void setUp() {
        transactionWithdrawal = initTransaction(20,ActionType.WITHDRAWAL);
        transactionDeposit =  initTransaction(40,ActionType.DEPOSIT);
    }

    @Test
    public void testFormatTransactionWithdrawalToPrint() {
        String expected = "01-01-12  12:00:00  |20.0                |                    |-20.0               ";
        Assert.assertEquals(expected, TemplatePrinter.formatTransactionToPrint(transactionWithdrawal,ConstantSeparator.SEPARATOR.PIPE, ConstantPrinter.SIZE_COLUMN));
    }

    @Test
    public void testFormatTransactionDepositToPrint() {
        String expected = "01-01-12  12:00:00  |                    |40.0                |40.0                ";
        Assert.assertEquals(expected,TemplatePrinter.formatTransactionToPrint(transactionDeposit,ConstantSeparator.SEPARATOR.PIPE, ConstantPrinter.SIZE_COLUMN));
    }

    @Test
    public void testHeader(){
        String expected = "Date                |Withdrawal          |Deposit             |Balance             ";
        Assert.assertEquals(expected,TemplatePrinter.getHeader());
    }
}