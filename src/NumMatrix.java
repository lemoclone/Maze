
public class NumMatrix {
    public int[][] matrix;
    public int[][] matrixSum;
    
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        this.matrix = new int[row][col];
        this.matrixSum = new int[row][col];
        
        this.matrixSum[0][0] = matrix[0][0];
        
        for(int i=1; i<row; i++){
        	this.matrixSum[0][i] = matrix[0][i] + this.matrixSum[0][i-1];
        }
        
        for(int i=1; i<col; i++){
        	this.matrixSum[i][0] = matrix[i][0] + this.matrixSum[i-1][0];
        }
      
        
        for(int i=1; i<row; i++)
            for(int j=1; j<col; j++){
                this.matrix[i][j] = matrix[i][j];
                this.matrixSum[i][j] =  matrix[i][j] + matrix[i-1][j] + this.matrixSum[i][j-1]; 
                matrix[i][j] += matrix[i-1][j];
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1==0 && col1==0)
            return matrixSum[row2][col2];
        if(row1 == 0)
            return matrixSum[row2][col2]-matrixSum[row2][col1];
        if(col1 == 0)
            return matrixSum[row2][col2]-matrixSum[row1][col2];
        return matrixSum[row2][col2]-matrixSum[row2][col1-1]-matrixSum[row1-1][col2]+matrixSum[row1-1][col1-1];
    }
}
