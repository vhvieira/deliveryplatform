package app.enums;

/**
 * Created by Avell on 12/10/2018.
 */
public enum ContractType {
    SPONTANEOUS("SPONTANEOUS"),
    BILLED("BILLED")
    ;

    private final String text;

    ContractType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
