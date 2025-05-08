package com.lawrencema.chess.model;

public class ChessBoard {
    public Piece[][] board;

    public ChessBoard() {
        board = new Piece[8][8];
        setupGame();
    }

    private void setupGame() {
        board[0][0] = new Rook(PieceColor.WHITE, new Position(0, 0));
        board[0][7] = new Rook(PieceColor.WHITE, new Position(0, 7));
        board[7][0] = new Rook(PieceColor.BLACK, new Position(7, 0));
        board[7][7] = new Rook(PieceColor.BLACK, new Position(7, 7));

        board[0][1] = new Knight(PieceColor.WHITE, new Position(0, 1));
        board[0][6] = new Knight(PieceColor.WHITE, new Position(0, 6));
        board[7][1] = new Knight(PieceColor.BLACK, new Position(7, 1));
        board[7][6] = new Knight(PieceColor.BLACK, new Position(7, 6));

        board[0][2] = new Bishop(PieceColor.WHITE, new Position(0, 2));
        board[0][5] = new Bishop(PieceColor.WHITE, new Position(0, 5));
        board[7][2] = new Bishop(PieceColor.BLACK, new Position(7, 2));
        board[7][5] = new Bishop(PieceColor.BLACK, new Position(7, 5));

        board[0][3] = new Queen(PieceColor.WHITE, new Position(0, 3));
        board[7][3] = new Queen(PieceColor.BLACK, new Position(7, 3));

        board[0][4] = new King(PieceColor.WHITE, new Position(0, 4));
        board[7][4] = new King(PieceColor.BLACK, new Position(7, 4));

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(PieceColor.WHITE, new Position(1, i));
        }
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(PieceColor.BLACK, new Position(6, i));
        }
    }

    public void movePiece(Position start, Position end){
        // see if there's a piece at starting location.
        // see if it's a valid move (constraint of board, mechanic of piece)
        if(board[start.getRow()][start.getCol()] != null && board[start.getRow()][start.getCol()].isValidMove(end, board)){
        // has to be start.isValidMove because the reference is the starting point
            // move piece
            board[end.getRow()][end.getCol()] = board[start.getRow()][start.getCol()];
            // update position. Instance needs to know where it is.
            board[end.getRow()][end.getCol()].setPosition(end);
            // clear start position
            board[start.getRow()][start.getCol()] = null;
            // update game condition (check, checkmate, stalemate, piece captured)
                // need to see more than just isValidMove of the current piece. Need to see isValidMove of all pieces that can possibly affect game condition.
                // example: exposed checkmate. exposed check.
        }

        // is this method part of Piece or is it part of ChessBoard? -> CHESSBOARD

    }

    public void printBoard() {
        for (int row = 7; row >= 0; row--) {
            System.out.print((row + 1) + " ");  // Print row number
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(piece.toString() + " ");
                }
            }
            System.out.println();
        }

        // Print column letters
        System.out.print("  ");
        for (char c = 'a'; c <= 'h'; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
