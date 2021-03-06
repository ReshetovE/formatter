package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.implementation.core.FormatterException;
import it.sevenbits.formatter.implementation.core.IFormatter;
import it.sevenbits.formatter.implementation.statemachine.Context;
import it.sevenbits.formatter.implementation.statemachine.core.ICommand;
import it.sevenbits.formatter.implementation.statemachine.core.ICommandRepository;
import it.sevenbits.formatter.implementation.statemachine.core.IContext;
import it.sevenbits.formatter.implementation.statemachine.core.IState;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.implementation.statemachine.core.IStateTransitions;
import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.lexer.LexerConfig;
import it.sevenbits.formatter.lexer.core.ILexer;
import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.lexer.core.ILexerFactory;
import it.sevenbits.formatter.lexer.core.LexerConfigException;

/**
 * Formatter implementation.
 */
public class Formatter implements IFormatter {
    private ICommandRepository commands;
    private IStateTransitions transitions;
    private ILexerFactory lexerFactory;

    /**
     * Constructor formatter.
     * @param lexerFactory Lexer factory.
     * @param formatterConfig Formatter config.
     */
    public Formatter(final ILexerFactory lexerFactory, final FormatterConfig formatterConfig) {
        this.lexerFactory = lexerFactory;
        this.commands = formatterConfig.getCommand();
        this.transitions = formatterConfig.getState();
    }

    /**
     * Method Formatter.
     * @param in Input interface Reader.
     * @param out Output interface Writer.
     * @throws FormatterException ReaderException/WriterException.
     */
    public void format(final IReader in, final IWriter out) throws FormatterException, LexerConfigException {

        IState state = new State("DefaultState");
        IContext context = new Context(out);
        LexerConfig lexerConfig = new LexerConfig();

        ILexer lexer = lexerFactory.createLexer(in, lexerConfig);
         try {
             while (lexer.hasMoreTokens()) {
                 IToken token = lexer.readToken();

                 ICommand command = commands.getCommand(state, token);
                 command.execute(token, context);

                 state = transitions.nextState(state, token);
             }
         } catch (Exception e) {
             throw new FormatterException("Method format failed", e);
         }
    }
}
