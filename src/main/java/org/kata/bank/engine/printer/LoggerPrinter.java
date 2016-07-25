package org.kata.bank.engine.printer;

import org.kata.bank.constants.ConstantPrinter;
import org.kata.bank.utils.TemplatePrinter;
import org.kata.bank.constants.ConstantSeparator;
import org.kata.bank.engine.Statement;
import org.kata.bank.engine.transaction.Transaction;
import org.apache.log4j.Logger;

/**
 * Created by salefebvre on 24/07/2016.
 */
public class LoggerPrinter implements Printer {

    private static final Logger LOGGER = Logger.getLogger(Statement.class);

    @Override
    public void print(Statement statement) {
        if(statement != null) {
            if (statement.getTransactionList().isEmpty()) {
                LOGGER.info("No transaction found");
            } else {
                LOGGER.info(TemplatePrinter.getHeader());
                for (Transaction transaction : statement.getTransactionList()) {
                   LOGGER.info(TemplatePrinter.formatTransactionToPrint(transaction, ConstantSeparator.SEPARATOR.PIPE, ConstantPrinter.SIZE_COLUMN));
                }
            }
        }
    }
}
