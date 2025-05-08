package com.lawrencema.chess.model;

public class Position {
    //need to use the Piece[8][8] grid.
    private int row;
    private int col;
    public Position(int row, int col){
        this.row = row;
        this.col = col;

    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }

    public int setLocation(int row, int col){
        this.row = row;
        this.col = col;
        return 0;
    }

    public String toString(){
        return "(" + row + "," + col + ")";
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position other = (Position) obj;
        return col == other.col || row == other.row;
    }

//    public boolean equals(Object obj) {
//        if (obj instanceof Position) {
//            Position pos = (Position) obj;
//            return (this.row == pos.row && this.col == pos.col);
//        }
//        return false;
//    }
    // this one works with subclasses of Position too, whereas the top one is strictly Position.
}
