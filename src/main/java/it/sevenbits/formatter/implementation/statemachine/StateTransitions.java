package it.sevenbits.formatter.implementation.statemachine;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.core.IState;
import it.sevenbits.formatter.implementation.statemachine.core.IStateTransitions;

import java.util.HashMap;

/**
 * State transitions implements.
 */
public class StateTransitions implements IStateTransitions {

    private HashMap<Pair, IState> map;

    /**
     * Constructor command repository.
     */
    public StateTransitions() {
        //Default state.
        Pair<State, String> pairDefaultSimpleChar = new Pair<>(new State("DefaultState"), "Char");
        Pair<State, String> pairDefaultOpenBracket = new Pair<>(new State("DefaultState"), "OpenBracket");
        Pair<State, String> pairDefaultCloseBracket = new Pair<>(new State("DefaultState"), "CloseBracket");
        Pair<State, String> pairDefaultSemicolon = new Pair<>(new State("DefaultState"), "Semicolon");
        Pair<State, String> pairDefaultSpace = new Pair<>(new State("DefaultState"), "Space");
        Pair<State, String> pairDefaultNewLine = new Pair<>(new State("DefaultState"), "NewLine");
        Pair<State, String> pairDefaultStringLiteral = new Pair<>(new State("DefaultState"), "StringLiteral");
        Pair<State, String> pairDefaultSingleLineComment = new Pair<>(new State("DefaultState"), "SingleLineComment");
        Pair<State, String> pairDefaultOpenMultiLineComment = new Pair<>(new State("DefaultState"), "OpenMultiLineComment");
        Pair<State, String> pairDefaultCloseMultiLineComment = new Pair<>(new State("DefaultState"), "CloseMultiLineComment");
        Pair<State, String> pairDefaultForLoops = new Pair<>(new State("DefaultState"), "ForLoops");
        Pair<State, String> pairDefaultCloseRoundBracket = new Pair<>(new State("DefaultState"), "CloseRoundBracket");
        Pair<State, String> pairDefaultIgnoreStringLiteral = new Pair<>(new State("DefaultState"), "IgnoreStringLiteral");

        //NewLine state.
        Pair<State, String> pairNewLineSimpleChar = new Pair<>(new State("NewLineState"), "Char");
        Pair<State, String> pairNewLineOpenBracket = new Pair<>(new State("NewLineState"), "OpenBracket");
        Pair<State, String> pairNewLineCloseBracket = new Pair<>(new State("NewLineState"), "CloseBracket");
        Pair<State, String> pairNewLineSemicolon = new Pair<>(new State("NewLineState"), "Semicolon");
        Pair<State, String> pairNewLineSpace = new Pair<>(new State("NewLineState"), "Space");
        Pair<State, String> pairNewLineNewLine = new Pair<>(new State("NewLineState"), "NewLine");
        Pair<State, String> pairNewLineStringLiteral = new Pair<>(new State("NewLineState"), "StringLiteral");
        Pair<State, String> pairNewLineSingleLineComment = new Pair<>(new State("NewLineState"), "SingleLineComment");
        Pair<State, String> pairNewLineOpenMultiLineComment = new Pair<>(new State("NewLineState"), "OpenMultiLineComment");
        Pair<State, String> pairNewLineCloseMultiLineComment = new Pair<>(new State("NewLineState"), "CloseMultiLineComment");
        Pair<State, String> pairNewLineForLoops = new Pair<>(new State("NewLineState"), "ForLoops");
        Pair<State, String> pairNewLineCloseRoundBracket = new Pair<>(new State("NewLineState"), "CloseRoundBracket");
        Pair<State, String> pairNewLineIgnoreStringLiteral = new Pair<>(new State("NewLineState"), "IgnoreStringLiteral");

        //StringLiteral state.
        Pair<State, String> pairStringLiteralSimpleChar = new Pair<>(new State("StringLiteralState"), "Char");
        Pair<State, String> pairStringLiteralOpenBracket = new Pair<>(new State("StringLiteralState"), "OpenBracket");
        Pair<State, String> pairStringLiteralCloseBracket = new Pair<>(new State("StringLiteralState"), "CloseBracket");
        Pair<State, String> pairStringLiteralSemicolon = new Pair<>(new State("StringLiteralState"), "Semicolon");
        Pair<State, String> pairStringLiteralSpace = new Pair<>(new State("StringLiteralState"), "Space");
        Pair<State, String> pairStringLiteralNewLine = new Pair<>(new State("StringLiteralState"), "NewLine");
        Pair<State, String> pairStringLiteralStringLiteral = new Pair<>(new State("StringLiteralState"), "StringLiteral");
        Pair<State, String> pairStringLiteralSingleLineComment = new Pair<>(new State("StringLiteralState"), "SingleLineComment");
        Pair<State, String> pairStringLiteralOpenMultiLineComment = new Pair<>(new State("StringLiteralState"), "OpenMultiLineComment");
        Pair<State, String> pairStringLiteralCloseMultiLineComment = new Pair<>(new State("StringLiteralState"), "CloseMultiLineComment");
        Pair<State, String> pairStringLiteralForLoops = new Pair<>(new State("StringLiteralState"), "ForLoops");
        Pair<State, String> pairStringLiteralCloseRoundBracket = new Pair<>(new State("StringLiteralState"), "CloseRoundBracket");
        Pair<State, String> pairStringLiteralIgnoreStringLiteral = new Pair<>(new State("StringLiteralState"), "IgnoreStringLiteral");

        //SingleLineComment state.
        Pair<State, String> pairSingleLineCommentSimpleChar = new Pair<>(new State("SingleLineCommentState"), "Char");
        Pair<State, String> pairSingleLineCommentOpenBracket = new Pair<>(new State("SingleLineCommentState"), "OpenBracket");
        Pair<State, String> pairSingleLineCommentCloseBracket = new Pair<>(new State("SingleLineCommentState"), "CloseBracket");
        Pair<State, String> pairSingleLineCommentSemicolon = new Pair<>(new State("SingleLineCommentState"), "Semicolon");
        Pair<State, String> pairSingleLineCommentSpace = new Pair<>(new State("SingleLineCommentState"), "Space");
        Pair<State, String> pairSingleLineCommentNewLine = new Pair<>(new State("SingleLineCommentState"), "NewLine");
        Pair<State, String> pairSingleLineCommentStringLiteral = new Pair<>(new State("SingleLineCommentState"), "StringLiteral");
        Pair<State, String> pairSingleLineCommentSingleLineComment = new Pair<>(new State("SingleLineCommentState"), "SingleLineComment");
        Pair<State, String> pairSingleLineCommentOpenMultiLineComment = new Pair<>(new State("SingleLineCommentState"), "OpenMultiLineComment");
        Pair<State, String> pairSingleLineCommentCloseMultiLineComment = new Pair<>(new State("SingleLineCommentState"), "CloseMultiLineComment");
        Pair<State, String> pairSingleLineCommentForLoops = new Pair<>(new State("SingleLineCommentState"), "ForLoops");
        Pair<State, String> pairSingleLineCommentCloseRoundBracket = new Pair<>(new State("SingleLineCommentState"), "CloseRoundBracket");
        Pair<State, String> pairSingleLineCommentIgnoreStringLiteral = new Pair<>(new State("SingleLineCommentState"), "IgnoreStringLiteral");

        //MultiLineComment state.
        Pair<State, String> pairMultiLineCommentSimpleChar = new Pair<>(new State("MultiLineCommentState"), "Char");
        Pair<State, String> pairMultiLineCommentOpenBracket = new Pair<>(new State("MultiLineCommentState"), "OpenBracket");
        Pair<State, String> pairMultiLineCommentCloseBracket = new Pair<>(new State("MultiLineCommentState"), "CloseBracket");
        Pair<State, String> pairMultiLineCommentSemicolon = new Pair<>(new State("MultiLineCommentState"), "Semicolon");
        Pair<State, String> pairMultiLineCommentSpace = new Pair<>(new State("MultiLineCommentState"), "Space");
        Pair<State, String> pairMultiLineCommentNewLine = new Pair<>(new State("MultiLineCommentState"), "NewLine");
        Pair<State, String> pairMultiLineCommentStringLiteral = new Pair<>(new State("MultiLineCommentState"), "StringLiteral");
        Pair<State, String> pairMultiLineCommentSingleLineComment = new Pair<>(new State("MultiLineCommentState"), "SingleLineComment");
        Pair<State, String> pairMultiLineCommentOpenMultiLineComment = new Pair<>(new State("MultiLineCommentState"), "OpenMultiLineComment");
        Pair<State, String> pairMultiLineCommentCloseMultiLineComment = new Pair<>(new State("MultiLineCommentState"), "CloseMultiLineComment");
        Pair<State, String> pairMultiLineCommentForLoops = new Pair<>(new State("MultiLineCommentState"), "ForLoops");
        Pair<State, String> pairMultiLineCommentCloseRoundBracket = new Pair<>(new State("MultiLineCommentState"), "CloseRoundBracket");
        Pair<State, String> pairMultiLineCommentIgnoreStringLiteral = new Pair<>(new State("MultiLineCommentState"), "IgnoreStringLiteral");

        //ForLoops state.
        Pair<State, String> pairForLoopsSimpleChar = new Pair<>(new State("ForLoopsState"), "Char");
        Pair<State, String> pairForLoopsOpenBracket = new Pair<>(new State("ForLoopsState"), "OpenBracket");
        Pair<State, String> pairForLoopsCloseBracket = new Pair<>(new State("ForLoopsState"), "CloseBracket");
        Pair<State, String> pairForLoopsSemicolon = new Pair<>(new State("ForLoopsState"), "Semicolon");
        Pair<State, String> pairForLoopsSpace = new Pair<>(new State("ForLoopsState"), "Space");
        Pair<State, String> pairForLoopsNewLine = new Pair<>(new State("ForLoopsState"), "NewLine");
        Pair<State, String> pairForLoopsStringLiteral = new Pair<>(new State("ForLoopsState"), "StringLiteral");
        Pair<State, String> pairForLoopsSingleLineComment = new Pair<>(new State("ForLoopsState"), "SingleLineComment");
        Pair<State, String> pairForLoopsOpenMultiLineComment = new Pair<>(new State("ForLoopsState"), "OpenMultiLineComment");
        Pair<State, String> pairForLoopsCloseMultiLineComment = new Pair<>(new State("ForLoopsState"), "CloseMultiLineComment");
        Pair<State, String> pairForLoopsForLoops = new Pair<>(new State("ForLoopsState"), "ForLoops");
        Pair<State, String> pairForLoopsCloseRoundBracket = new Pair<>(new State("ForLoopsState"), "CloseRoundBracket");
        Pair<State, String> pairForLoopsIgnoreStringLiteral = new Pair<>(new State("ForLoopsState"), "IgnoreStringLiteral");

        map = new HashMap<>();

        //Default state.
        map.put(pairDefaultSimpleChar, new State("DefaultState"));
        map.put(pairDefaultOpenBracket, new State("NewLineState"));
        map.put(pairDefaultCloseBracket, new State("NewLineState"));
        map.put(pairDefaultSemicolon, new State("NewLineState"));
        map.put(pairDefaultSpace, new State("DefaultState"));
        map.put(pairDefaultNewLine, new State("NewLineState"));
        map.put(pairDefaultStringLiteral, new State("StringLiteralState"));
        map.put(pairDefaultSingleLineComment, new State("SingleLineCommentState"));
        map.put(pairDefaultOpenMultiLineComment, new State("MultiLineCommentState"));
        map.put(pairDefaultCloseMultiLineComment, new State("DefaultState"));
        map.put(pairDefaultForLoops, new State("ForLoopsState"));
        map.put(pairDefaultCloseRoundBracket, new State("DefaultState"));
        map.put(pairDefaultIgnoreStringLiteral, new State("DefaultState"));

        //NewLine state.
        map.put(pairNewLineSimpleChar, new State("DefaultState"));
        map.put(pairNewLineOpenBracket, new State("NewLineState"));
        map.put(pairNewLineCloseBracket, new State("NewLineState"));
        map.put(pairNewLineSemicolon, new State("NewLineState"));
        map.put(pairNewLineSpace, new State("NewLineState"));
        map.put(pairNewLineNewLine, new State("NewLineState"));
        map.put(pairNewLineStringLiteral, new State("StringLiteralState"));
        map.put(pairNewLineSingleLineComment, new State("SingleLineCommentState"));
        map.put(pairNewLineOpenMultiLineComment, new State("MultiLineCommentState"));
        map.put(pairNewLineCloseMultiLineComment, new State("DefaultState"));
        map.put(pairNewLineForLoops, new State("ForLoopsState"));
        map.put(pairNewLineCloseRoundBracket, new State("DefaultState"));
        map.put(pairNewLineIgnoreStringLiteral, new State("DefaultState"));

        // StringLiteral state.
        map.put(pairStringLiteralSimpleChar, new State("StringLiteralState"));
        map.put(pairStringLiteralOpenBracket, new State("StringLiteralState"));
        map.put(pairStringLiteralCloseBracket, new State("StringLiteralState"));
        map.put(pairStringLiteralSemicolon, new State("StringLiteralState"));
        map.put(pairStringLiteralSpace, new State("StringLiteralState"));
        map.put(pairStringLiteralNewLine, new State("StringLiteralState"));
        map.put(pairStringLiteralStringLiteral, new State("DefaultState"));
        map.put(pairStringLiteralSingleLineComment, new State("StringLiteralState"));
        map.put(pairStringLiteralOpenMultiLineComment, new State("StringLiteralState"));
        map.put(pairStringLiteralCloseMultiLineComment, new State("StringLiteralState"));
        map.put(pairStringLiteralForLoops, new State("StringLiteralState"));
        map.put(pairStringLiteralCloseRoundBracket, new State("StringLiteralState"));
        map.put(pairStringLiteralIgnoreStringLiteral, new State("StringLiteralState"));

        // SingleLineComment state.
        map.put(pairSingleLineCommentSimpleChar, new State("SingleLineCommentState"));
        map.put(pairSingleLineCommentOpenBracket, new State("SingleLineCommentState"));
        map.put(pairSingleLineCommentCloseBracket, new State("SingleLineCommentState"));
        map.put(pairSingleLineCommentSemicolon, new State("SingleLineCommentState"));
        map.put(pairSingleLineCommentSpace, new State("SingleLineCommentState"));
        map.put(pairSingleLineCommentNewLine, new State("NewLineState"));
        map.put(pairSingleLineCommentStringLiteral, new State("SingleLineCommentState"));
        map.put(pairSingleLineCommentSingleLineComment, new State("SingleLineCommentState"));
        map.put(pairSingleLineCommentOpenMultiLineComment, new State("SingleLineCommentState"));
        map.put(pairSingleLineCommentCloseMultiLineComment, new State("SingleLineCommentState"));
        map.put(pairSingleLineCommentForLoops, new State("SingleLineCommentState"));
        map.put(pairSingleLineCommentCloseRoundBracket, new State("SingleLineCommentState"));
        map.put(pairSingleLineCommentIgnoreStringLiteral, new State("SingleLineCommentState"));

        // MultiLineComment state.
        map.put(pairMultiLineCommentSimpleChar, new State("MultiLineCommentState"));
        map.put(pairMultiLineCommentOpenBracket, new State("MultiLineCommentState"));
        map.put(pairMultiLineCommentCloseBracket, new State("MultiLineCommentState"));
        map.put(pairMultiLineCommentSemicolon, new State("MultiLineCommentState"));
        map.put(pairMultiLineCommentSpace, new State("MultiLineCommentState"));
        map.put(pairMultiLineCommentNewLine, new State("MultiLineCommentState"));
        map.put(pairMultiLineCommentStringLiteral, new State("MultiLineCommentState"));
        map.put(pairMultiLineCommentSingleLineComment, new State("MultiLineCommentState"));
        map.put(pairMultiLineCommentOpenMultiLineComment, new State("MultiLineCommentState"));
        map.put(pairMultiLineCommentCloseMultiLineComment, new State("DefaultState"));
        map.put(pairMultiLineCommentForLoops, new State("MultiLineCommentState"));
        map.put(pairMultiLineCommentCloseRoundBracket, new State("MultiLineCommentState"));
        map.put(pairMultiLineCommentIgnoreStringLiteral, new State("MultiLineCommentState"));

        // ForLoops state.
        map.put(pairForLoopsSimpleChar, new State("ForLoopsState"));
        map.put(pairForLoopsOpenBracket, new State("ForLoopsState"));
        map.put(pairForLoopsCloseBracket, new State("ForLoopsState"));
        map.put(pairForLoopsSemicolon, new State("ForLoopsState"));
        map.put(pairForLoopsSpace, new State("ForLoopsState"));
        map.put(pairForLoopsNewLine, new State("ForLoopsState"));
        map.put(pairForLoopsStringLiteral, new State("ForLoopsState"));
        map.put(pairForLoopsSingleLineComment, new State("ForLoopsState"));
        map.put(pairForLoopsOpenMultiLineComment, new State("ForLoopsState"));
        map.put(pairForLoopsCloseMultiLineComment, new State("ForLoopsState"));
        map.put(pairForLoopsForLoops, new State("ForLoopsState"));
        map.put(pairForLoopsCloseRoundBracket, new State("DefaultState"));
        map.put(pairForLoopsIgnoreStringLiteral, new State("ForLoopsState"));
    }


    @Override
    public IState nextState(final IState state, final IToken token) {
        Pair currentPair = new Pair<>(state, token.getName());
        return map.get(currentPair);
    }
}
