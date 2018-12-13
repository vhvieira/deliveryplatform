package app.enums;

/**
 * Created by Avell on 13/10/2018.
 */
public enum PaymentStatus {
    PENDING("PENDING"),
    PAID("PAID")
    ;

    private final String text;

    PaymentStatus(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
