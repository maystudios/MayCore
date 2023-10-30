/**
 * A utility class that offers matrix operations such as multiplication by a scalar
 * and matrix multiplication. All matrix elements and scalars are assumed to be
 * instances of classes that extend java.lang.Number.
 */
public class Matrix {
    
    /**
     * Multiplies each element of a matrix by a scalar.
     * 
     * @param <T> A numeric type that extends java.lang.Number
     * @param matrix The input matrix to be multiplied
     * @param scalar The scalar by which each element of the matrix will be multiplied
     * @return A new matrix where each element is the product of the corresponding element
     *         in the input matrix and the scalar
     */
    public static <T extends Number> double[][] multiplyMatrixByScalar(T[][] matrix, T scalar) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        double[][] result = new double[rows][columns];
        
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                result[i][j] = matrix[i][j].doubleValue() * scalar.doubleValue();
        
        return result;
    }
    
    /**
     * Multiplies two matrices and returns the resulting matrix.
     * 
     * @param <T> A numeric type that extends java.lang.Number
     * @param matrixA The first matrix to be multiplied
     * @param matrixB The second matrix to be multiplied
     * @return A new matrix that is the result of multiplying matrixA by matrixB
     * @throws IllegalArgumentException If the number of columns in matrixA is not equal
     *                                  to the number of rows in matrixB
     */
    public static <T extends Number> double[][] multiplyMatrices(T[][] matrixA, T[][] matrixB) {
        int rowsA = matrixA.length, columnsA = matrixA[0].length, columnsB = matrixB[0].length;
        
        if (columnsA != matrixB.length) {
            throw new IllegalArgumentException("Number of columns in matrixA must be equal to number of rows in matrixB.");
        }
        
        double[][] result = new double[rowsA][columnsB];
        
        for (int i = 0; i < rowsA; i++)
            for (int j = 0; j < columnsB; j++)
                for (int k = 0; k < columnsA; k++)
                    result[i][j] += matrixA[i][k].doubleValue() * matrixB[k][j].doubleValue();
        
        return result;
    }
}
