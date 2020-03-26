package chess.domain.view;

import java.util.Optional;

import chess.domain.board.Board;
import chess.domain.board.Column;
import chess.domain.board.Position;
import chess.domain.board.Row;
import chess.domain.piece.Piece;

public class OutputView {
    public static void instruction() {
        System.out.println("> 체스 게임을 시작합니다.\n"
            + "> 게임 시작 : start\n"
            + "> 게임 종료 : end\n"
            + "> 게임 이동 : move source위치 target위치 - 예. move b2 b3");
    }

    public static void showBoard(Board board) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Row row : Row.values()) {
            parseRow(board, stringBuilder, row);
        }
        System.out.println(stringBuilder.toString());
    }

    public static void parseRow(final Board board, final StringBuilder stringBuilder, final Row row) {
        for (Column column : Column.values()) {
            stringBuilder.append(parsedPiece(board.findPieceBy(Position.of(row, column))));
        }
        stringBuilder.append(System.lineSeparator());
    }

    private static String parsedPiece(Optional<Piece> piece) {
        if (piece.isPresent()) {
            return piece.get().toString();
        }
        return ".";
    }
}