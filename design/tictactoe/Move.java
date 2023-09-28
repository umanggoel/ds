package design.tictactoe;

public class Move {

    int player;
    int row;
    int col;
    public Move(int player, int row, int col) {
        this.player = player;
        this.row = row;
        this.col = col;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
