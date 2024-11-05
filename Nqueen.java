import java.util.*;
public class Nqueen {

    static int row = 4;

    static public List<List<String>> createBoard(int n){
        List<List<String>> res = new ArrayList<List<String>>();
        char[][] board= new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '-';
            }
        } 
        queenPositions(0,board,res);
        return res;
    }

    static List<String> construct(char[][]board){
        List<String> ls = new ArrayList<String>();
        for(int i=0;i<board.length;i++){
            String s = new String(board[i]);
            ls.add(s);
        }
        return ls;

    }

    static boolean validate(int row , int col, char[][] board){

        int drow = row;
        int dcol = col;

        while(row>=0 && col>=0){
            if(board[row][col]=='Q')
                return false;
            row--;
            col--;
        }

        row = drow;
        col = dcol;
        while(col>=0){
            if(board[row][col]=='Q')
                return false;
            col--;
        }
        row = drow;
        col = dcol;
        while(col>=0 && row <board.length){
            if(board[row][col]=='Q')
                return false;
            row++;
            col--;
        }
        return true;
    }

    static void queenPositions(int col,char[][] board,List<List<String>>res){

        if(col==board.length){
            res.add(construct(board));
            return;

        }
        

        for(int row=0;row<board.length;row++){
            if(validate(row,col,board)){
                board[row][col]='Q';
                queenPositions(col+1, board, res);
                board[row][col]='-';

            }

        
    }
    }

    public static void main(String [] args){
        System.out.print("Enter board dimensions : ");
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

      
      
            List<List<String>> res = createBoard(n);
            int count = 1;

            for(List<String> t : res ){
                System.out.println("Arrangement "+count);
                for(String s : t){
                    System.out.println(s);
                }
                System.out.println(" ");
                count++;
            }
        }
       
    }
    
}
