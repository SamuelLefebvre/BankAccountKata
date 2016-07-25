package org.kata.bank.engine;

/**
 * Created by salefebvre on 23/07/2016.
 */
public class Amount {

    /**
     *  valeur du montant
     */
    private float value;

    public Amount(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    /**
     * Retourne la valeur sous la forme d'un string
     * @return
     */
    public String getValueToString() {
        return String.valueOf(value);
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount = (Amount) o;

        return Float.compare(amount.value, value) == 0;

    }

    @Override
    public int hashCode() {
        return (value != +0.0f ? Float.floatToIntBits(value) : 0);
    }
}
