package it.sevenbits.formatter.implementation.core;

/**
 * Exception for Formatter class.
 */
public class FormatterException extends Exception {

    /**
     * ReaderException for Formatter.
     * @param s Message Exception.
     * @param e Exception.
     */
    public FormatterException(final String s, final Throwable e) {
        super(s, e);
    }
}
