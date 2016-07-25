package org.kata.bank.utils;

import org.kata.bank.constants.ActionType;
import org.kata.bank.constants.ConstantPrinter;
import org.kata.bank.constants.ConstantSeparator;
import org.kata.bank.engine.transaction.Transaction;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by salefebvre on 24/07/2016.
 */
public final class TemplatePrinter {

    private static final int SIZE_BUFFER = 40;

    /**
     *  Contruit une chaine de caractère correspondant à la transaction
     * @param transaction
     * @param separator
     * @param size
     * @return
     */
    public static String formatTransactionToPrint(Transaction transaction, ConstantSeparator.SEPARATOR separator, int size) {
        StringBuffer stringBuffer = new StringBuffer(SIZE_BUFFER);
        stringBuffer.append(StringUtils.rightPad(transaction.getDateFormat(), size));
        stringBuffer.append(separator.getCode());
        if(transaction.getType().equals(ActionType.WITHDRAWAL)) {
            stringBuffer.append(StringUtils.rightPad(transaction.getAmount().getValueToString(), size));
        } else {
            stringBuffer.append(StringUtils.rightPad(StringUtils.EMPTY, size));
        }
        stringBuffer.append(separator.getCode());
        if(transaction.getType().equals(ActionType.DEPOSIT)) {
            stringBuffer.append(StringUtils.rightPad(transaction.getAmount().getValueToString(), size));
        } else {
            stringBuffer.append(StringUtils.rightPad(StringUtils.EMPTY, size));
        }
        stringBuffer.append(separator.getCode());
        stringBuffer.append(StringUtils.rightPad(String.valueOf(transaction.getBalance()), size));
        return stringBuffer.toString();
    }

    /**
     * Génère l'en-tete du fichier
     *
     * @return
     */
    public static String getHeader() {
        StringBuffer stringBuffer;
        stringBuffer = new StringBuffer(ConstantPrinter.SIZE_BUFFER);
        stringBuffer.append(StringUtils.rightPad(ConstantPrinter.DATE, ConstantPrinter.SIZE_COLUMN));
        stringBuffer.append(ConstantSeparator.SEPARATOR.PIPE.getCode());
        stringBuffer.append(StringUtils.rightPad(ConstantPrinter.WITHDRAWAL, ConstantPrinter.SIZE_COLUMN));
        stringBuffer.append(ConstantSeparator.SEPARATOR.PIPE.getCode());
        stringBuffer.append(StringUtils.rightPad(ConstantPrinter.DEPOSIT, ConstantPrinter.SIZE_COLUMN));
        stringBuffer.append(ConstantSeparator.SEPARATOR.PIPE.getCode());
        stringBuffer.append(StringUtils.rightPad(ConstantPrinter.BALANCE, ConstantPrinter.SIZE_COLUMN));
        return stringBuffer.toString();
    }
}
