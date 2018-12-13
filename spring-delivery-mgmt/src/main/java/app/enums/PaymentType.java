package app.enums;

/**
 * Created by Avell on 13/10/2018.
 */
public enum PaymentType {
    MONEY("MONEY"),
    TRANSFER("TRANSFER")
    ;

    private final String text;

    PaymentType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
