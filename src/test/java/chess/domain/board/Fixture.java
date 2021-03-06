package chess.domain.board;

import chess.domain.piece.Piece;
import chess.domain.piece.Side;
import chess.domain.piece.Type;
import org.junit.jupiter.params.provider.Arguments;

import java.util.HashMap;

public class Fixture {
    static final Arguments EMPTY_STARTING_POINT = Arguments.of(
            "시작점이 비어있으면 예외 발생",
            new HashMap<Position, Piece>() {{
                put(Position.of(Row.FOUR, Column.D), Piece.of(Type.BISHOP, Side.WHITE));
            }}, Position.of(Row.ONE, Column.A), Position.of(Row.FOUR, Column.D));

    static final Arguments ENEMY_ON_END_POINT = Arguments.of(
            "끝에 적이 있는 경우",
            new HashMap<Position, Piece>() {{
                put(Position.of(Row.ONE, Column.A), Piece.of(Type.QUEEN, Side.BLACK));
                put(Position.of(Row.FOUR, Column.D), Piece.of(Type.QUEEN, Side.WHITE));
            }}, Position.of(Row.ONE, Column.A), Position.of(Row.FOUR, Column.D), true);

    static final Arguments NO_ENEMY_ON_END_POINT = Arguments.of(
            "끝에 적이 없는 경우",
            new HashMap<Position, Piece>() {{
                put(Position.of(Row.ONE, Column.A), Piece.of(Type.QUEEN, Side.BLACK));
                put(Position.of(Row.FOUR, Column.D), Piece.of(Type.QUEEN, Side.BLACK));
            }}, Position.of(Row.ONE, Column.A), Position.of(Row.FOUR, Column.D), false);

    static final Arguments NO_ENEMY_OR_ALLY_ON_END_POINT = Arguments.of(
            "끝이 비어서 적이 없는 경우",
            new HashMap<Position, Piece>() {{
                put(Position.of(Row.ONE, Column.A), Piece.of(Type.QUEEN, Side.BLACK));
            }}, Position.of(Row.ONE, Column.A), Position.of(Row.FOUR, Column.D), false);

    static final Arguments EMPTY_ON_END_POINT = Arguments.of(
            "끝이 빈 경우",
            new HashMap<Position, Piece>() {{
                put(Position.of(Row.ONE, Column.A), Piece.of(Type.QUEEN, Side.BLACK));
            }}, Position.of(Row.ONE, Column.A), Position.of(Row.FOUR, Column.D), true);

    static final Arguments NOT_EMPTY_ON_END_POINT = Arguments.of(
            "끝이 비지 않은 경우",
            new HashMap<Position, Piece>() {{
                put(Position.of(Row.ONE, Column.A), Piece.of(Type.QUEEN, Side.BLACK));
                put(Position.of(Row.FOUR, Column.D), Piece.of(Type.QUEEN, Side.BLACK));
            }}, Position.of(Row.ONE, Column.A), Position.of(Row.FOUR, Column.D), false);

    static final Arguments BLOCKED_PATH = Arguments.of(
            "장애물이 있는 경우",
            new HashMap<Position, Piece>() {{
                put(Position.of(Row.ONE, Column.A), Piece.of(Type.QUEEN, Side.BLACK));
                put(Position.of(Row.TWO, Column.B), Piece.of(Type.QUEEN, Side.BLACK));
            }}, Position.of(Row.ONE, Column.A), Position.of(Row.FOUR, Column.D), true);

    static final Arguments NOT_BLOCKED_PATH = Arguments.of(
            "장애물이 없는 경우",
            new HashMap<Position, Piece>() {{
                put(Position.of(Row.ONE, Column.A), Piece.of(Type.QUEEN, Side.BLACK));
                put(Position.of(Row.FOUR, Column.D), Piece.of(Type.QUEEN, Side.BLACK));
            }}, Position.of(Row.ONE, Column.A), Position.of(Row.FOUR, Column.D), false);
}
