package ru.vsu.cs.mosyakin;
/**
 * Класс операций над матрицей.
 * @version 1.2
 */
public class MatrixOperations {
    /**
     * Получение определителя.
     * Возвращает определитель.
     */
    protected static float getDeterminant(float[][] matrix) {
        if(matrix.length != matrix[0].length){
            throw new ArithmeticException("The number of matrix columns is not equal to the number of rows");
        }else {
            float result = 0;

            if (matrix.length == 1) {
                return matrix[0][0];
            }

            for (int i = 0; i < matrix[0].length; i++) {
                result += (float) (Math.pow(-1, i) * matrix[0][i] * getDeterminant(reduceMatrix(matrix, 0, i)));
            }

            return result;
        }
    }
    /**
     * Уменьшение матрицы на 1.
     * Возвращает матрицу.
     */
    private static float[][] reduceMatrix(float[][] matrix, int lineIndex, int columnIndex) {
        return reduceMatrixColumns(reduceMatrixLines(matrix, lineIndex), columnIndex);
    }
    /**
     * Уменьшение матрицы на строку.
     * Возвращает матрицу.
     */
    private static float[][] reduceMatrixLines(float[][] matrix, int index) {
        float[][] newMatrix = new float[matrix.length - 1][matrix[0].length];

        for (int i = 0; i < index; i++) {
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, newMatrix[i].length);
        }
        for (int i = index; i < newMatrix.length; i++) {
            System.arraycopy(matrix[i + 1], 0, newMatrix[i], 0, newMatrix[i].length);
        }

        return newMatrix;
    }
    /**
     * Уменьшение матрицы на столбец.
     * Возвращает матрицу.
     */
    private static float[][] reduceMatrixColumns(float[][] matrix, int index) {
        float[][] newMatrix = new float[matrix.length][matrix[0].length - 1];

        for (int i = 0; i < newMatrix.length; i++) {
            if (index >= 0) {
                System.arraycopy(matrix[i], 0, newMatrix[i], 0, index);
            }
            if (newMatrix[i].length - index >= 0) {
                System.arraycopy(matrix[i], index + 1, newMatrix[i], index, newMatrix[i].length - index);
            }
        }

        return newMatrix;
    }
    /**
     * Сложение матриц.
     * Возвращает матрицу.
     */
    protected static float[][] plus(float[][] matrixFirst, float[][] matrixSecond) {
        if(matrixFirst.length != matrixFirst[0].length && matrixSecond.length != matrixSecond[0].length && matrixFirst.length != matrixSecond.length && matrixFirst[0].length != matrixSecond[0].length){
            throw new ArithmeticException("The number of columns of one of the matrices is not equal to the number of rows");
        }else {
            float[][] result = new float[matrixFirst.length][matrixFirst.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = matrixFirst[i][j] + matrixSecond[i][j];
                }
            }

            return result;
        }
    }
    /**
     * Вычитание матриц.
     * Возвращает матрицу.
     */
    protected static float[][] minus(float[][] matrixFirst, float[][] matrixSecond) {
        if(matrixFirst.length != matrixFirst[0].length && matrixSecond.length != matrixSecond[0].length && matrixFirst.length != matrixSecond.length && matrixFirst[0].length != matrixSecond[0].length){
            throw new ArithmeticException("The number of columns of one of the matrices is not equal to the number of rows");
        }else {
            float[][] result = new float[matrixFirst.length][matrixFirst.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = matrixFirst[i][j] - matrixSecond[i][j];
                }
            }

            return result;
        }
    }
    /**
     * Умножение матрицы на вектор.
     * Возвращает матрицу.
     */
    protected static float[] multiply(float[][] matrixFirst, float[] matrixSecond) {
        if(matrixFirst.length != matrixFirst[0].length && matrixFirst[0].length != matrixSecond.length){
            throw new ArithmeticException("The number of columns matrix is not equal to the number of rows or number matrix columns is not equal to the size of vector");
        }else {
            float[] result = new float[matrixFirst.length];
            for (int i = 0; i < result.length; i++) {
                float element = 0;
                for (int j = 0; j < matrixFirst.length; j++) {
                    element += matrixFirst[i][j] * matrixSecond[j];
                }
                result[i] = element;
            }

            return result;
        }
    }
    /**
     * Перемножение матриц.
     * Возвращает матрицу.
     */
    protected static float[][] multiply(float[][] matrixFirst, float[][] matrixSecond) {
        if(matrixFirst.length != matrixFirst[0].length && matrixSecond.length != matrixSecond[0].length && matrixFirst.length != matrixSecond.length && matrixFirst[0].length != matrixSecond[0].length){
            throw new ArithmeticException("The number of columns of one of the matrices is not equal to the number of rows");
        }else {

            float[][] result = new float[matrixFirst.length][matrixFirst.length];

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    float element = 0;
                    for (int k = 0; k < result.length; k++) {
                        element += matrixFirst[i][k] * matrixSecond[k][j];
                    }

                    result[i][j] = element;
                }
            }

            return result;
        }
    }
    /**
     * Умножение матрицы на скаляр.
     * Возвращает матрицу.
     */
    protected static float[][] multiplyScalar(float[][] matrixFirst, float scalar) {
        if(matrixFirst.length != matrixFirst[0].length){
            throw new ArithmeticException("The number of matrix columns is not equal to the number of rows");
        }else {
            float[][] result = new float[matrixFirst.length][matrixFirst.length];

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = matrixFirst[i][j] * scalar;
                }
            }

            return result;
        }
    }
    /**
     * Создание нулевой матрицы.
     * Возвращает матрицу.
     */
    protected static float[][] createNullMatrix(int size) {
        float[][] matrix = new float[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 0;
            }
        }

        return matrix;
    }
    /**
     * Создание единичной матрицы.
     * Возвращает матрицу.
     */
    protected static float[][] createUnitMatrix(int size) {
        float[][] matrix = new float[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (i == j) ? 1 : 0;
            }
        }

        return matrix;
    }
    /**
     * Делает из матрицы обратную матрицу.
     * Возвращает матрицу.
     */
    protected static float[][] inverseMatrix(float[][] matrix) {
        float determinant = getDeterminant(matrix);
        if (determinant == 0) {
            throw new ArithmeticException("Matrix is not invertible");
        }else {

            float[][] returnMatrix = new float[matrix.length][matrix.length];

            for (int i = 0; i < returnMatrix.length; i++) {
                for (int j = 0; j < returnMatrix.length; j++) {
                    returnMatrix[i][j] = (float) Math.pow(-1, i + j) * getDeterminant(reduceMatrix(matrix, i, j));
                }
            }

            return transpose(multiplyScalar(returnMatrix, 1 / determinant));
        }
    }
    /**
     * Транспонирование матрицы.
     * Возвращает матрицу.
     */
    protected static float[][] transpose(float[][] matrix) {
        if(matrix.length != matrix[0].length){
            throw new ArithmeticException("The number of matrix columns is not equal to the number of rows");
        }else {
            float[][] returnMatrix = new float[matrix.length][matrix.length];

            for (int i = 0; i < returnMatrix.length; i++) {
                for (int j = 0; j < returnMatrix.length; j++) {
                    returnMatrix[j][i] = matrix[i][j];
                }
            }

            return returnMatrix;
        }
    }
}