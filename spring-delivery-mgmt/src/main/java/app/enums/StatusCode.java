package app.enums;

/**
 * Created by Rafael Leal on 13/10/2018.
 */
public enum StatusCode {
    A("A"),
    D("D");

    private final String text;

    StatusCode(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
