package chess.domain;

import chess.domain.pieces.Piece;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ChessGame {
    private static final int COMMAND_POSITION = 0;
    private static final int COMMAND_FROM_POSITION = 1;
    private static final int COMMAND_TO_POSITION = 2;
    private static final String MOVE_COMMAND = "move";
    private static final String DELIMITER = " ";
    private static final String X_AXIS_REFERENCE = "abcdefgh";
    private static final int COMMAND_SIZE = 3;
    private Board board;
    private ChessTeam turn;

    public ChessGame() {
        board = BoardCreator.create();
        turn = ChessTeam.WHITE;
    }

    public void play(String from, String to) {
        String command = MOVE_COMMAND + DELIMITER + from + DELIMITER + to;
        play(command);
    }

    public void play(String input) {
        List<String> split = tokenizeCommand(input);
        validate(split);
        board.play(parse(split.get(COMMAND_FROM_POSITION)), parse(split.get(COMMAND_TO_POSITION)), turn);
        changeTurn();
    }

    private void changeTurn() {
        turn = turn.change();
    }

    private void validate(List<String> split) {
        if (split.size() != COMMAND_SIZE) {
            throw new IllegalArgumentException();
        }
        if (!split.get(COMMAND_POSITION).equals(MOVE_COMMAND)) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> tokenizeCommand(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    public boolean checkEndGame() {
        return board.check(turn);
    }

    public ChessResult winner() {
        return result(turn.change());
    }

    private Point parse(String destination) {
        int x = X_AXIS_REFERENCE.indexOf(destination.charAt(COMMAND_FROM_POSITION - 1)) + 1;
        int y = Integer.parseInt(String.valueOf(destination.charAt(COMMAND_TO_POSITION - 1)));
        return Point.get(x, y);
    }

    public Piece get(Point point) {
        return board.get(point);
    }

    public ChessResult result(ChessTeam team) {
        return new ChessResult(board.result(team), team);
    }

    public Map<String, String> status() {
        return board.status();
    }
}