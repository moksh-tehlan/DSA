package backtracking;

public class KnightTour {
    public static void main(String[] args) {
        int n = 5;
        int[][] ans = knightProblem(n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int[][] knightProblem(int n){
        int[][] ans = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans[i][j] = -1;
            }
        }
        ans[0][0] = 0;

        int[] moveX = {2,1,-1,-2,-2,-1,1,2};
        int[] moveY = {1,2,2,1,-1,-2,-2,-1};
        knightProblemHelper(n,moveX,moveY,ans,1,0,0);
        return ans;
    }

    static boolean knightProblemHelper(int n, int[] moveX, int[] moveY, int[][] ans, int step, int currX,int currY){
        if(step == n*n)return true;

        for(int i = 0 ; i < 8; i++){
            int nextX = moveX[i] + currX;
            int nextY = moveY[i] + currY;
            if(isValidCoordinates(nextX,nextY,ans,n)){
                ans[nextX][nextY] = step;
                boolean isValidPathWithTheseCoordinates = knightProblemHelper(n,moveX,moveY,ans,step+1,nextX,nextY);
                if (isValidPathWithTheseCoordinates){
                    return true;
                }else{
                    ans[nextX][nextY] = -1;
                }
            }
        }
        return false;
    }

    static boolean isValidCoordinates(int x,int y, int[][] ans,int n){
        return x >= 0 && y >= 0 && x < n && y < n && ans[x][y] == -1;
    }
}
