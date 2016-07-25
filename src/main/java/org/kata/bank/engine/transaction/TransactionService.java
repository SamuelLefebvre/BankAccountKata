package org.kata.bank.engine.transaction;

import org.kata.bank.constants.ActionType;
import org.kata.bank.engine.Amount;

import java.util.Date;

/**
 * Created by salefebvre on 24/07/2016.
 */
public interface TransactionService {

    /**
     * Sauvegarde une transaction
     * @param date
     * @param amount
     * @param type
     */
    void saveTransaction(Date date, Amount amount, ActionType type);
}
