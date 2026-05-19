import java.util.*;

class Solution {
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for (char[] row : board)
            Arrays.fill(row,'.');
        solve(board,0,n);
        return ans;
    }
    void solve(char[][] board,int row,int n) 
    {
        if(row==n) 
        {
            List<String> temp=new ArrayList<>();
            for (char[] r : board)
                temp.add(new String(r));
            ans.add(temp);
            return;
        }
        for(int col=0;col<n;col++) 
        {
            if(isSafe(board,row,col,n)) 
            {
                board[row][col]='Q';
                solve(board,row+1,n);
                board[row][col]='.';
            }
        }
    }
    boolean isSafe(char[][] board,int row,int col,int n) 
    {
        // upper column
        for(int i=0;i<row;i++)
            if(board[i][col]=='Q')
                return false;
        // left diagonal
        for(int i=row,j=col;i>=0 && j>=0;i--,j--)
            if(board[i][j]=='Q')
                return false;
        // right diagonal
        for(int i=row,j=col;i>=0 && j<n;i--,j++)
            if(board[i][j]=='Q')
                return false;
        return true;
    }
}
