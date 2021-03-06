package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.implementation.core.FormatterConfigException;
import it.sevenbits.formatter.implementation.core.FormatterException;
import it.sevenbits.formatter.implementation.core.IFormatter;
import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.io.string_io.StringReader;
import it.sevenbits.formatter.io.string_io.StringWriter;
import it.sevenbits.formatter.lexer.LexerFactory;
import it.sevenbits.formatter.lexer.core.ILexer;
import it.sevenbits.formatter.lexer.Lexer;
import it.sevenbits.formatter.lexer.core.LexerConfigException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterTest {

    @Test
    public void testBigTestFormatter() throws FormatterException, FormatterConfigException, LexerConfigException {
        IReader reader = new StringReader(
                "p {" +
                        "  abc() { " +
                        "   fun( );" +
                        "       }" +
                        "}"
        );
        IWriter writer = new StringWriter();

        FormatterConfig formatterConfig = new FormatterConfig();
        IFormatter formatter = new Formatter(new LexerFactory(), formatterConfig);
        formatter.format(reader, writer);
        assertEquals("p {\n" +
                                "    abc() {\n" +
                                "        fun( );\n" +
                                "    }\n" +
                                "}", writer.toString());
    }

    @Test
    public void testSimpleFormat() throws FormatterException, FormatterConfigException, LexerConfigException {
        IReader reader = new StringReader(
                "a;   b"
        );
        IWriter writer = new StringWriter();

        FormatterConfig formatterConfig = new FormatterConfig();
        IFormatter formatter = new Formatter(new LexerFactory(), formatterConfig);
        formatter.format(reader, writer);
        assertEquals("a;\nb", writer.toString());
    }

    @Test
    public void testSemicolon() throws FormatterException, FormatterConfigException, LexerConfigException {
        IReader reader = new StringReader(
                "sdfsdf;dfsd"
        );
        IWriter writer = new StringWriter();

        FormatterConfig formatterConfig = new FormatterConfig();
        IFormatter formatter = new Formatter(new LexerFactory(), formatterConfig);
        formatter.format(reader, writer);
        assertEquals("sdfsdf;\ndfsd", writer.toString());
    }

    @Test
    public void testOpenBrackets() throws FormatterException, FormatterConfigException, LexerConfigException {
        IReader reader = new StringReader(
                "a{" +
                        " p;" +
                        "{"
        );
        IWriter writer = new StringWriter();

        FormatterConfig formatterConfig = new FormatterConfig();
        IFormatter formatter = new Formatter(new LexerFactory(), formatterConfig);
        formatter.format(reader, writer);
        assertEquals("a{\n" +
                              "    p;\n" +
                              "    {", writer.toString());
    }

    @Test
    public void testCloseBrackets() throws FormatterException, FormatterConfigException, LexerConfigException {
        IReader reader = new StringReader(
                "a{" +
                        " p;" +
                        "}"
        );
        IWriter writer = new StringWriter();

        FormatterConfig formatterConfig = new FormatterConfig();
        IFormatter formatter = new Formatter(new LexerFactory(), formatterConfig);
        formatter.format(reader, writer);
        assertEquals("a{\n" +
                "    p;\n" +
                "}", writer.toString());
    }

    @Test
    public void testSemicolonNewLine() throws FormatterException, FormatterConfigException, LexerConfigException {
        IReader reader = new StringReader(
                "a{" +
                        " ;p;" +
                        "}"
        );
        IWriter writer = new StringWriter();

        FormatterConfig formatterConfig = new FormatterConfig();
        IFormatter formatter = new Formatter(new LexerFactory(), formatterConfig);
        formatter.format(reader, writer);
        assertEquals("a{\n" +
                                "    ;\n" +
                                "    p;\n" +
                                "}", writer.toString());
    }

    @Test
    public void testNewLineNewLine() throws FormatterException, FormatterConfigException, LexerConfigException {
        IReader reader = new StringReader(
                "a{" +
                        " \n\n;p;" +
                        "}"
        );
        IWriter writer = new StringWriter();

        FormatterConfig formatterConfig = new FormatterConfig();
        IFormatter formatter = new Formatter(new LexerFactory(), formatterConfig);
        formatter.format(reader, writer);
        assertEquals("a{\n" +
                "    ;\n" +
                "    p;\n" +
                "}", writer.toString());
    }

    @Test
    public void testStringLiteral() throws FormatterException, FormatterConfigException, LexerConfigException {
        IReader reader = new StringReader(
                "\"{};\n sdf  sdv\""
        );
        IWriter writer = new StringWriter();

        FormatterConfig formatterConfig = new FormatterConfig();
        IFormatter formatter = new Formatter(new LexerFactory(), formatterConfig);
        formatter.format(reader, writer);
        assertEquals("\"{};\n sdf  sdv\"", writer.toString());
    }

    @Test
    public void testDoubleToken() throws FormatterException, FormatterConfigException, LexerConfigException {
        IReader reader = new StringReader(
                "//ab{}\n" +
                        "{" +
                        "//c;c"
        );
        IWriter writer = new StringWriter();

        FormatterConfig formatterConfig = new FormatterConfig();
        IFormatter formatter = new Formatter(new LexerFactory(), formatterConfig);
        formatter.format(reader, writer);
        assertEquals("//ab{}\n" +
                                "{\n" +
                                "    //c;c", writer.toString());
    }

    @Test
    public void testOpenMultiLineComment() throws FormatterException, FormatterConfigException, LexerConfigException {
        IReader reader = new StringReader(
                "/* {};\n" +
                        "sdf"
        );
        IWriter writer = new StringWriter();

        FormatterConfig formatterConfig = new FormatterConfig();
        IFormatter formatter = new Formatter(new LexerFactory(), formatterConfig);
        formatter.format(reader, writer);
        assertEquals("/* {};\n" +
                              "sdf", writer.toString());
    }

    @Test
    public void testMultiLineComment() throws FormatterException, FormatterConfigException, LexerConfigException {
        IReader reader = new StringReader(
                "\n/*{}*5*//*"
        );
        IWriter writer = new StringWriter();

        FormatterConfig formatterConfig = new FormatterConfig();
        IFormatter formatter = new Formatter(new LexerFactory(), formatterConfig);
        formatter.format(reader, writer);
        assertEquals("\n/*{}*5*//*", writer.toString());
    }

    @Test
    public void testForLoops() throws FormatterException, FormatterConfigException, LexerConfigException {
        IReader reader = new StringReader(
                "for (int i = 0; i < 10; i++) {"
        );
        IWriter writer = new StringWriter();

        FormatterConfig formatterConfig = new FormatterConfig();
        IFormatter formatter = new Formatter(new LexerFactory(), formatterConfig);
        formatter.format(reader, writer);
        assertEquals("for (int i = 0; i < 10; i++) {", writer.toString());
    }

    @Test
    public void testSecondForLoops() throws FormatterException, FormatterConfigException, LexerConfigException {
        IReader reader = new StringReader(
                "for {};;\n{)"
        );
        IWriter writer = new StringWriter();

        FormatterConfig formatterConfig = new FormatterConfig();
        IFormatter formatter = new Formatter(new LexerFactory(), formatterConfig);
        formatter.format(reader, writer);
        assertEquals("for {};;\n{)", writer.toString());
    }

    @Test
    public void testIgnoreStringLiteral() throws FormatterException, FormatterConfigException, LexerConfigException {
        IReader reader = new StringReader(
                "\"\\\"\""
        );
        IWriter writer = new StringWriter();


        FormatterConfig formatterConfig = new FormatterConfig();
        IFormatter formatter = new Formatter(new LexerFactory(), formatterConfig);
        formatter.format(reader, writer);
        assertEquals("\"\\\"\"", writer.toString());
    }
}
