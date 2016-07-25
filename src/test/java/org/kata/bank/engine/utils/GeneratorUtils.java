package org.kata.bank.engine.utils;

import org.kata.bank.constants.ActionType;
import org.kata.bank.engine.Amount;
import org.kata.bank.engine.transaction.Transaction;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by salefebvre on 25/07/2016.
 */
public class GeneratorUtils {

    /**
     * Fournit une date
     * @return
     */
    public static Date getDate() {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.set(2012, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * Fournit une transaction
     * @param value
     * @param type
     * @return
     */
    public static Transaction initTransaction(float value, ActionType type) {
        Amount amount = new Amount(value);
        return new Transaction(getDate(),amount, type);
    }
}
