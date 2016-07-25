package org.kata.bank.constants;

import org.kata.bank.utils.Enumerable;

/**
 * Created by salefebvre on 23/07/2016.
 */
public class ConstantSeparator {

    /**
     * Liste des séparateurs de l'application
     */
    public enum SEPARATOR implements Enumerable {
        PIPE("PIPE","|");

        private final String code;
        private final String text;

        SEPARATOR(String text, String code) {
            this.code = code;
            this.text = text;
        }
        public String getCode() {
            return code;
        }

        public String getText() {
            return text;
        }
    }


}
