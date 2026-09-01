class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m=classroom.length;
        int n=classroom[0].length();
        int startR=0,startC=0;
        int litterCount=0;
        // Assign each litter a bit index
        int[][] litterIndex=new int[m][n];
        for(int[] row : litterIndex) {
            Arrays.fill(row,-1);
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                char ch=classroom[i].charAt(j);
                if(ch=='S') {
                    startR=i;
                    startC=j;
                } else if(ch=='L') {
                    litterIndex[i][j]=litterCount++;
                }
            }
        }
        int allCollected=(1<<litterCount)-1;
        if(litterCount==0) 
        return 0;
        // visited[row][col][mask][remainingEnergy]
        boolean[][][][] visited=new boolean[m][n][1<<litterCount][energy+1];
        Queue<int[]> queue=new LinkedList<>();
        // State: row, col, collectedMask, remainingEnergy, moves
        queue.offer(new int[]{startR,startC,0,energy,0});
        visited[startR][startC][0][energy]=true;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        while(!queue.isEmpty()) {
            int[] curr=queue.poll();
            int r=curr[0];
            int c=curr[1];
            int mask=curr[2];
            int remainingEnergy=curr[3];
            int moves=curr[4];
            for(int d=0;d<4;d++) {
                int nr=r+dr[d];
                int nc=c+dc[d];
                if(nr<0 || nr>=m || nc<0 || nc>=n)
                    continue;
                char cell=classroom[nr].charAt(nc);
                if(cell=='X')
                    continue;
                // Cannot make a move without energy
                if(remainingEnergy==0)
                    continue;
                int newEnergy=remainingEnergy-1;
                int newMask=mask;
                // Collect litter
                if(cell=='L') {
                    newMask|=(1<<litterIndex[nr][nc]);
                }
                // Reset energy
                if(cell=='R') {
                    newEnergy=energy;
                }
                // All litter collected
                if(newMask==allCollected) {
                    return moves+1;
                }
                if(!visited[nr][nc][newMask][newEnergy]) {
                    visited[nr][nc][newMask][newEnergy]=true;
                    queue.offer(new int[]{
                            nr,nc,newMask,newEnergy,moves+1
                    });
                }
            }
        }
        return -1;
    }
}
