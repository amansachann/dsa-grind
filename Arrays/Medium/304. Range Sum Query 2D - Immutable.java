// Brute force
class NumMatrix {
    int[][] mat; 
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        mat = new int[rows][cols];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                mat[i][j] = matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1; i<=row2; i++) {
            for(int j=col1; j<=col2; j++) {
                sum+=mat[i][j];
            }
        }
        return sum;
    }
}

