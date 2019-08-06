package OA;
// game-> tic tac toe
public class TicTacToe {
    public boolean designGame(String[] board){
        int len = board.length;
        int[] row = new int[len];
        int[] col = new int[len];
        int diagonal = 0;
        int anti_diagonal = 0;
        int first = 0;
        int second = 0;
        char win = ' ';
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(board[i].charAt(j)=='X'){
                    // not stop game
                    if(win!=' ') return false;
                    row[i]+=1;
                    col[j]+=1;
                    first++;
                }else if(board[i].charAt(j)=='O'){
                    if(win!=' ') return false;
                    row[i]-=1;
                    col[j]-=1;
                    second++;
                }
                if(i==j){
                    diagonal+=1;
                }else if(i==(len-1-j)){
                    anti_diagonal+=1;
                }
                // take turn failed


                if(Math.abs(row[i])==len || Math.abs(col[j])==len|| Math.abs(diagonal)==len || Math.abs(anti_diagonal) ==len){
                    if(row[i]>0){
                        win = 'X';
                    }else{
                        win = 'O';
                    }
                    if(Math.abs(first-second)>1 || (second==1 && first==0))return false;


                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        String[] board = {"X X"};
    }
}
