package design.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {

    Integer board[][];
    List<Move> move ;
    public Board(int size){
        board = new Integer[size][size];
        move  = new ArrayList<>();
    }

    public Integer[][] getBoard() {
        return board;
    }

    public void setBoard(Integer[][] board) {
        this.board = board;
    }

    public Move getLastMove() {
        return move.get(move.size());
    }

    public void addMove(Move move) {
        this.move.add(move);
    }


}
