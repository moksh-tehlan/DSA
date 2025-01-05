package backtracking;

public class RatMazeProblem {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1,0},
                {1,1,1,0},
                {1,1,1,0},
                {1,1,1,1},
        };

        int n = matrix.length;
        int m = matrix[0].length;

        ratMaze(matrix,n,m,0,0,"");
    }

    static boolean isValid(int [][] matrix, int n , int m, int i , int j){
        if(i < n && j < m && i >= 0 && j >= 0 && matrix[i][j] == 1){
            return true;
        }else{
            return false;
        }
    }

    // DLRU
    static void ratMaze(int[][] matrix,int n,int m, int i , int j,String path){
        if(i == n-1 && j == m-1){
            System.out.println(path);
            return;
        }

        // Checking if we can do down
        if(isValid(matrix,n,m,i+1,j)){

            // marking the current index as visited
            matrix[i+1][j] = 0;
            ratMaze(matrix,n,m,i+1,j,path+"D");

            // falling back to the previous position
            matrix[i+1][j] = 1;
        }

        // Checking if we can go left
        if(isValid(matrix,n,m,i,j-1)){
            matrix[i][j-1] = 0;
            ratMaze(matrix,n,m,i,j-1,path+"L");
            matrix[i][j-1] = 1;
        }

        // Checking if we can go right
        if(isValid(matrix,n,m,i,j+1)){
            matrix[i][j+1] = 0;
            ratMaze(matrix,n,m,i,j+1,path+"R");
            matrix[i][j+1] = 1;
        }

        // Checking if we can do up
        if(isValid(matrix,n,m,i-1,j)){
            matrix[i-1][j] = 0;
            ratMaze(matrix,n,m,i-1,j,path+"U");
            matrix[i-1][j] = 1;
        }
    }
}
