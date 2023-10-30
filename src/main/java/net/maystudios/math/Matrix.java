public class Matrix {
    
    public static <T extends Number> double[][] multiplyMatrixByScalar(T[][] matrix, T scalar) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        double[][] result = new double[rows][columns];
        
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                result[i][j] = matrix[i][j].doubleValue() * scalar.doubleValue();
        
        return result;
    }
    
    public static <T extends Number> double[][] multiplyMatrices(T[][] matrixA, T[][] matrixB) {
        int rowsA = matrixA.length, columnsA = matrixA[0].length, columnsB = matrixB[0].length;
        double[][] result = new double[rowsA][columnsB];
        
        for (int i = 0; i < rowsA; i++)
            for (int j = 0; j < columnsB; j++)
                for (int k = 0; k < columnsA; k++)
                    result[i][j] += matrixA[i][k].doubleValue() * matrixB[k][j].doubleValue();
        
        return result;
    }
}
