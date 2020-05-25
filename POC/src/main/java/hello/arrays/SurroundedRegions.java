package com.company.arrays;

public class SurroundedRegions {
    public void solve(char[][] board) {

        if(board.length == 0) return;
        if(board[0].length == 0) return;

        int j;
        int i;
        for(i=0;i<board.length;i++){
            if(board[i][0] == 'O'){
                mark(i,0,board);
            }
            if(board[i][board[0].length-1] =='O'){
                mark(i,board[0].length-1,board);
            }
        }

        for(j=0;j<board[0].length;j++){
            if(board[0][j] == 'O'){
                mark(0,j,board);
            } if(board[board.length-1][j] =='O'){
                mark(board.length-1,j,board);
            }
        }

        for( i=0;i<board.length;i++){
            for( j=0;j<board[0].length;j++){
                if(board[i][j] == 'O')
                    board[i][j] ='X';
                if(board[i][j] == 'Z')
                    board[i][j] ='O';

            }
        }
    }

    private void mark(int i, int j, char[][] board){

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] !='O') return;

        board[i][j] = 'Z';

        mark(i+1,j,board);
        mark(i-1,j,board);
        mark(i,j+1,board);
        mark(i,j-1,board);
    }
}
