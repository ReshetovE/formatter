package it.sevenbits.formatter.lexer.statemachine.command;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.io.string_io.StringReader;
import it.sevenbits.formatter.lexer.LexerConfig;
import it.sevenbits.formatter.lexer.core.ILexer;
import it.sevenbits.formatter.lexer.Lexer;
import it.sevenbits.formatter.lexer.core.LexerConfigException;
import it.sevenbits.formatter.lexer.core.LexerException;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class NewLineCommandTest {

    @Test
    public void testSimpleSemicolonCommand() throws LexerException, LexerConfigException {
        IReader reader = new StringReader("\n");
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("NewLine", token.getName());
        assertEquals("\n", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());
    }

    @Test
    public void testNotEqualsSemicolonCommand() throws LexerException, LexerConfigException {
        IReader reader = new StringReader("\n");
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertNotEquals("CloseBracket", token.getName());
        assertNotEquals("}", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());
    }
}
