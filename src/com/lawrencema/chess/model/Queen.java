package com.lawrencema.chess.model;

import static com.lawrencema.chess.util.PieceUtils.*;

public class Queen extends Piece {
    public Queen(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public String toString() {
        return (getColor() == PieceColor.WHITE) ? "Q" : "q";
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

//        if(board[endRow][endCol].toString().equals("K") || board[endRow][endCol].toString().equals("k"))
        // this is brittle because toString method can be changed.

        //not respecting obstacles
        //find move direction and cycle through that direction to find obstacles.

        int rowDirection = Integer.signum(endRow - startRow);
        //(endRow - startRow) / Math.abs(endRow - startRow);
        int colDirection = Integer.signum(endCol - startCol);
        int distance = Math.max(Math.abs(endRow - startRow), Math.abs(endCol - startCol));


        for(int i = 1; i < distance; i++){
            if(board[startRow + rowDirection * i][startCol + colDirection * i] != null) {
                System.out.println("Rook is obstructed");
                return false;
            }
        }
        return true;
    }
}
