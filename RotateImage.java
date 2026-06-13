class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        // Transpose the matrix
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        // Reverse each row
        for(int i=0;i<n;i++) {
            int lt=0;
            int rt=n-1;
            while(lt<rt) {
                int temp=matrix[i][lt];
                matrix[i][lt]=matrix[i][rt];
                matrix[i][rt]=temp;
                lt++;
                rt--;
            }
        }
    }
}
