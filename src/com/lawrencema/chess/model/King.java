package com.lawrencema.chess.model;
import static com.lawrencema.chess.util.PieceUtils.*;

public class King extends Piece {
    public King(PieceColor color, Position position) {
        super(color, position);
    } @Override
    public String toString() {
        return (getColor() == PieceColor.WHITE) ? "K" : "k";
    }
    @Override
    public boolean isValidMove(Position position, Piece[][] board) {
        int startRow = getPosition().getRow();
        int startCol = getPosition().getCol();
        int endRow = position.getRow();
        int endCol = position.getCol();

        Piece target = board[endRow][endCol];

        //out of bounds
        if(isOutOfBounds(position))
            return false;

        //same position
        if(isSamePosition(getPosition(), position))
            return false;

        //same color
        if(isSameColor(this, target))
        return false;

        //captures king
        if(isCapturingKing(target))
            return false;

    }
}
