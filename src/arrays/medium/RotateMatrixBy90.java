package arrays.medium;

public class RotateMatrixBy90 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotateMatrix(matrix);
        for (int[] arr: matrix){
            for (int i : arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    static void rotateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // swap element at m[i][j] with m[j][i]
        for(int i = 0; i < row; i++){
            for(int j = i;  j < col; j++){
                swap(matrix,i,j);
            }
        }

        // now reverse the col.
        for(int i = 0;i < row; i++){
            reverseRow(matrix,i);
        }
    }

    static void swap(int[][] matrix,int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    static void reverseRow(int[][] matrix,int row){
        int start = 0;
        int end = matrix[0].length-1;
        while(start < end){
            int temp = matrix[row][start];
            matrix[row][start] = matrix[row][end];
            matrix[row][end] = temp;
            start++;
            end--;
        }
    }
}
