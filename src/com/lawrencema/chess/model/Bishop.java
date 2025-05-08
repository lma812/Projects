package com.lawrencema.chess.model;
import static com.lawrencema.chess.util.PieceUtils.*;

public class Bishop extends Piece {
    public Bishop(PieceColor color, Position position) {
        super(color, position);
    }
    @Override
    public String toString() {
        return (getColor() == PieceColor.WHITE) ? "B" : "b";
    }

    @Override
    public boolean isValidMove(Position position, Piece[][] board) {
        //if not within constraints of board, not horizontal or vertical, captures king, captures same color, not respect obstacles return false.
        int startRow = getPosition().getRow();
        int startCol = getPosition().getCol();
        int endRow = position.getRow();
        int endCol = position.getCol();

        Piece target = board[endRow][endCol];

        if(isOutOfBounds(position))
            return false;
        //doesn't move
//        if(startRow == endRow && startCol == endCol){
//            System.out.println("Bishop is moving to the same position");
//            return false;
//        }
        if(isSamePosition(getPosition(), position))
            return false;

        //same color

//        if(board[endRow][endCol] != null &&
//                board[startRow][startCol].getColor() == board[endRow][endCol].getColor()) {
//            System.out.println("Bishop is capturing the same color");
//            return false;
//        }
        if(isSameColor(this, target))
            return false;

        //captures king
//        if(board[endRow][endCol] instanceof King) {
//            System.out.println("Bishop is capturing the king");
//
//            return false;
//        }
        if(isCapturingKing(target))
            return false;


//        if(board[endRow][endCol].toString().equals("K") || board[endRow][endCol].toString().equals("k"))
        // this is brittle because toString method can be changed.

        //doesn't move like a bishop
        if(Math.abs(endRow - startRow) != Math.abs(endCol - startCol)) {
            System.out.println("Bishop is not moving like a bishop");
            return false;
        }

        //not respecting obstacles
        //find move direction and cycle through that direction to find obstacles.

        int rowDirection = Integer.signum(endRow - startRow);
        //(endRow - startRow) / Math.abs(endRow - startRow);
        int colDirection = Integer.signum(endCol - startCol);
        int distance = Math.abs(endRow - startRow);


        for(int i = 1; i < distance; i++){
            if(board[startRow + rowDirection * i][startCol + colDirection * i] != null) {
                System.out.println("Bishop is obstructed");
                return false;
            }
        }
        return true;
    }
}
