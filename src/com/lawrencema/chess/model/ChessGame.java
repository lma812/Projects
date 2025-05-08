package com.lawrencema.chess.model;

public class ChessGame {
    // manages game state
    // manage whether white or black moves
    // check, game over - resign, clock out, checkmate, stalemate

    private ChessBoard board;
    private boolean whiteTurn = true;

    public ChessGame(){
        this.board = new ChessBoard();
    }

    // only white can move.
    // start position must be a white piece
}
