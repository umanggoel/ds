package design.tictactoe;

public class TickTack {

    Board board;
    public TickTack(int size) {
        this.board = new Board(size);
    }

    public int makeMove(Move move){
        int val = move.player==0?-1 : 1;
        int row = move.getRow();
        int col = move.getCol();
        boolean hasWon = false;
        Integer[][] mat = board.getBoard();
        if(mat[row][col]==null){
            mat[row][col] = val;
        }
        // if row == 3, col==3, diag==3
        int rowSum =0, colSum =0, diaSumRL = 0, diaSumLR = 0;
        for(int i=0; i< mat.length; i++){
                rowSum+= mat[i][col];
                colSum += mat[row][i];
                diaSumRL += mat[i][i];
                diaSumLR += mat[mat.length-i][i];
        }
        if(rowSum==0 || colSum==0 || diaSumLR==0 || diaSumRL==0){
            hasWon = true;
        }

        if(hasWon)
            return 1;
        else
            return -1;
    }

}
