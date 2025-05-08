package com.lawrencema.chess.model;

public class Main {
    public static void main(String[] args) {
        ChessBoard newBoard = new ChessBoard();
        newBoard.printBoard();
        System.out.println("--------------------------------");
        newBoard.movePiece(newBoard.board[0][0].getPosition(), new Position(2,0));
        newBoard.printBoard();
    }
}
