class Solution {
    boolean issafe(char[][] board,int r,int c,int n){
        for(int i=0;i<board.length;i++){
            if(board[r][i]==(char)n+'0') return false;
            if(board[i][c]==(char)n+'0') return false;
        }
        int nr=(r/3)*3;
        int nc=(c/3)*3;
        for(int i=nr;i<nr+3;i++){
            for(int j=nc;j<nc+3;j++){
                if(board[i][j]==(char)n+'0') return false;
            }
        }
        return true;
    }
    boolean help(char[][] board,int r,int c){
        if(r==board.length) return true;
        int nr=0,nc=0;
        if(c!=board.length-1){
            nr=r;
            nc=c+1;
        }else{
            nr=r+1;
            nc=0;
        }

        if(board[r][c]!='.'){
            if(help(board,nr,nc)) return true;
        }else{
            for(int i=1;i<=9;i++){
                if(issafe(board,r,c,i)){
                    board[r][c]=(char)(i+'0');
                    if(help(board,nr,nc)) return true;
                    board[r][c]='.';
                }
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        help(board,0,0);
    }
}