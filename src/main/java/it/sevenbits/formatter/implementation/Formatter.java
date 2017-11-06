package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.core.*;

/**
 * Formatter implementation.
 */
public class Formatter implements IFormatter {

    /**
     * Method Formatter.
     * @param in Input interface FileReader.
     * @throws FormatterException ReaderException/WriterException.
     */
    public void format(final IReader in, final IWriter out) throws FormatterException {
        try {
            int b = 0;
            boolean checkEnter = false;

            while (in.hasChars()) {
                char c = in.readChar();
                switch (c) {
                    case ';':
                        out.write(";");
                        out.write("\n");
                        checkEnter = true;
                        break;
                    case '{':
                        b++;
                        out.write("{\n");
                        checkEnter = true;
                        break;
                    case '}':
                        for (int i = 0; i < (b - 1) * 4; i++) {
                            out.write(" ");
                        }
                        out.write("}\n");
                        checkEnter = true;
                        b--;
                        break;
                    default:
                        if(checkEnter) {
                            for (int i = 0; i < b * 4; i++) {
                                out.write(" ");
                            }
                            checkEnter = false;
                        }
                        String s = "" + c;
                        out.write(s);
                        break;
                }
            }
        } catch (ReaderException e) {
            throw new FormatterException("Method format failed", e);
        } catch (WriterException e) {
            throw new FormatterException("Method format failed", e);
        }
    }

    @Override
    public void close() throws Exception {

    }
}
