package com.lawrencema.chess.model;
import static com.lawrencema.chess.util.PieceUtils.*;

public class Rook extends Piece {
    public Rook(PieceColor color, Position position){
        super(color, position);
    }

    @Override
    public String toString() {
        return (getColor() == PieceColor.WHITE) ? "R" : "r";
    }

    @Override
    public boolean isValidMove(Position position, Piece[][] board) {
        //if not within constraints of board, not horizontal or vertical, captures king, captures same color, not respect obstacles return false.
        int startRow = getPosition().getRow();
        int startCol = getPosition().getCol();
        int endRow = position.getRow();
        int endCol = position.getCol();

        //out of bounds
        if(isOutOfBounds(position))
            return false;

        //doesn't move
        if(startRow == endRow && startCol == endCol){
            System.out.println("Rook is moving to the same position");
            return false;
        }


        //same color
        if(board[endRow][endCol] != null &&
           board[startRow][startCol].getColor() == board[endRow][endCol].getColor()) {
            System.out.println("Rook is capturing the same color");
            return false;
        }

        //captures king
        if(board[endRow][endCol] instanceof King) {
            System.out.println("Rook is capturing the king");

            return false;
        }

        //doesn't move like a rook
        if(startRow != endRow && startCol != endCol) {
            System.out.println("Rook is not moving like a rook");
            return false;
        }

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
        // this implementation doesn't take into account the bidirectional movement of the rook.
//        if(startRow == endRow){
//            for(int i = startCol + 1; i < endCol; i++)
//                if(board[startRow][i] != null)
//                    return false;
//        }
//
//        if(startCol == endCol){
//            for(int i = startRow + 1; i < endRow; i++)
//                if(board[i][startCol] != null)
//                    return false;
//        }



        //not respecting constraints of board
        //method will fail if this is the case.

    }
}
