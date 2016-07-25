package org.kata.bank.engine.printer;

import org.kata.bank.engine.Statement;

/**
 * Created by salefebvre on 24/07/2016.
 */
public interface Printer {
    void print(Statement statement);
}
