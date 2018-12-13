package app.enums;

/**
 * Created by Avell on 13/10/2018.
 */
public enum PhoneType {
    LAND_LINE("LAND_LINE"),
    MOBILE("MOBILE")
    ;

    private final String text;

    PhoneType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
