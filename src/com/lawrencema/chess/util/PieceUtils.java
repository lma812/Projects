package com.lawrencema.chess.util;

import com.lawrencema.chess.model.*;

public class PieceUtils {

    //doesn't move
    public static boolean isSamePosition(Position start, Position end) {
        return start.getRow() == end.getRow() && start.getColumn() == end.getColumn();
    }
    //same color
    public static boolean isSameColor(Piece start, Piece end) {
        return end != null && start.getColor() == end.getColor();
    }

    //captures king
    public static boolean isCapturingKing(Piece end) {
        return end instanceof King;
    }

    //out of bounds
    public static boolean isOutOfBounds(Position pos) {
        int row = pos.getRow();
        int col = pos.getCol();
        return row < 0 || row >= 8 || col < 0 || col >= 8;
    }

}
