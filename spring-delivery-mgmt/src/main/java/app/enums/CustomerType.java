package app.enums;

/**
 * Created by Avell on 12/10/2018.
 */
public enum CustomerType {
    LEGAL("LEGAL"),
    NATURAL("NATURAL")
    ;

    private final String text;

    CustomerType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
