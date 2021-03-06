package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.implementation.Token;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.io.string_io.StringReader;
import it.sevenbits.formatter.lexer.core.ILexer;
import it.sevenbits.formatter.lexer.core.LexerException;
import it.sevenbits.formatter.lexer.statemachine.LexerContext;
import it.sevenbits.formatter.lexer.statemachine.core.ILexerCommand;
import it.sevenbits.formatter.lexer.statemachine.core.ILexerCommandRepository;
import it.sevenbits.formatter.lexer.statemachine.core.ILexerStateTransitions;
import it.sevenbits.formatter.lexer.statemachine.core.ILexerContext;

/**
 * Lexical analyzer.
 */
public class Lexer implements ILexer {

    private final IReader reader;
    private ILexerCommandRepository commands;
    private ILexerStateTransitions transitions;
    private ILexerContext context = new LexerContext();


    /**
     * Constructor Lexer.
     * @param reader Reader.
     * @param lexerConfig Lexer config.
     */
    public Lexer(final IReader reader, final LexerConfig lexerConfig) {
        this.reader = reader;
        this.commands = lexerConfig.getCommand();
        this.transitions = lexerConfig.getState();
    }

    /**
     * Constructor for testing.
     * @param reader Reader.
     * @param commands Command repository.
     * @param transitions State transitions.
     */
    public Lexer(final IReader reader, final ILexerCommandRepository commands, final ILexerStateTransitions transitions) {
        this.reader = reader;
        this.commands = commands;
        this.transitions = transitions;
    }

    @Override
    public IToken readToken() throws LexerException {
        context.createNewLexeme();

        State state = new State("Default");

        try {
            IReader postponeReader = new StringReader(context.getPostponeBuffer().toString());
            while (postponeReader.hasNextChars() && state != null) {
                char c = postponeReader.readChar();
                ILexerCommand command = commands.getCommand(state, c);
                command.execute(c, context);
                state = transitions.getNextState(state, c);

            }
            context.createNewPostpone();

            while (reader.hasNextChars() && state != null) {
                char c = reader.readChar();
                ILexerCommand command = commands.getCommand(state, c);
                command.execute(c, context);
                state = transitions.getNextState(state, c);

            }

            return new Token(context.getTokenName(), context.getTokenLexeme().toString());

        } catch (Exception e) {
            throw new LexerException("Method readToken failed", e);
        }
    }

    @Override
    public boolean hasMoreTokens() throws LexerException {
        try {
            return context.getPostponeBuffer().length() > 0 || reader.hasNextChars();
        } catch (Exception e) {
            throw new LexerException("Failed or interrupted I/O operations", e);
        }
    }
}
