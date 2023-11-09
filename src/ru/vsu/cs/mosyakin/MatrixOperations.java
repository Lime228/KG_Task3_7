package ru.vsu.cs.mosyakin;
/**
 * Класс операций над матрицей.
 * @version 1.0
 */
public class MatrixOperations {
    /**
     * Получение определителя.
     * Возвращает определитель.
     */
    protected static float getDeterminant(float[][] elements) {
        if(elements.length != elements[0].length){
            throw new ArithmeticException("The number of matrix columns is not equal to the number of rows");
        }else {
            float result = 0;

            if (elements.length == 1) {
                return elements[0][0];
            }

            for (int j = 0; j < elements[0].length; j++) {
                result += (float) (Math.pow(-1, j) * elements[0][j] * getDeterminant(cutLineAndColumn(elements, 0, j)));
            }

            return result;
        }
    }
    /**
     * Уменьшение матрицы на 1.
     * Возвращает матрицу.
     */
    private static float[][] cutLineAndColumn(float[][] matrix, int indexLine, int indexColumn) {
        return cutColumn(cutLine(matrix, indexLine), indexColumn);
    }
    /**
     * Уменьшение матрицы на строку.
     * Возвращает матрицу.
     */
    private static float[][] cutLine(float[][] matrix, int index) {
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
    private static float[][] cutColumn(float[][] matrix, int index) {
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
    protected static float[][] add(float[][] elements, float[][] elements2) {
        if(elements.length != elements[0].length && elements2.length != elements2[0].length){
            throw new ArithmeticException("The number of columns of one of the matrices is not equal to the number of rows");
        }else {
            float[][] result = new float[elements.length][elements.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = elements[i][j] + elements2[i][j];
                }
            }

            return result;
        }
    }
    /**
     * Вычитание матриц.
     * Возвращает матрицу.
     */
    protected static float[][] subtract(float[][] elements, float[][] elements2) {
        if(elements.length != elements[0].length && elements2.length != elements2[0].length){
            throw new ArithmeticException("The number of columns of one of the matrices is not equal to the number of rows");
        }else {
            float[][] result = new float[elements.length][elements.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = elements[i][j] - elements2[i][j];
                }
            }

            return result;
        }
    }
    /**
     * Умножение матрицы на вектор.
     * Возвращает матрицу.
     */
    protected static float[] multiply(float[][] elements, float[] elements2) {
        if(elements.length != elements[0].length && elements2.length != elements2.length){
            throw new ArithmeticException("The number of columns matrix is not equal to the number of rows or number matrix columns is not equal to the size of vector");
        }else {
            float[] result = new float[elements.length];
            for (int i = 0; i < result.length; i++) {
                float element = 0;
                for (int j = 0; j < elements.length; j++) {
                    element += elements[i][j] * elements2[j];
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
    protected static float[][] multiply(float[][] elements, float[][] elements2) {
        if(elements.length != elements[0].length && elements2.length != elements2[0].length){
            throw new ArithmeticException("The number of columns of one of the matrices is not equal to the number of rows");
        }else {

            float[][] result = new float[elements.length][elements.length];

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    float element = 0;
                    for (int k = 0; k < result.length; k++) {
                        element += elements[i][k] * elements2[k][j];
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
    protected static float[][] multiplyScalar(float[][] elements, float scalar) {
        if(elements.length != elements[0].length){
            throw new ArithmeticException("The number of matrix columns is not equal to the number of rows");
        }else {
            float[][] result = new float[elements.length][elements.length];

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = elements[i][j] * scalar;
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
        float[][] nullMatrix = new float[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                nullMatrix[i][j] = 0;
            }
        }

        return nullMatrix;
    }
    /**
     * Создание единичной матрицы.
     * Возвращает матрицу.
     */
    protected static float[][] createUnitMatrix(int size) {
        float[][] unitMatrix = new float[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                unitMatrix[i][j] = (i == j) ? 1 : 0;
            }
        }

        return unitMatrix;
    }
    /**
     * Делает из матрицы обратную матрицу.
     * Возвращает матрицу.
     */
    protected static float[][] inverseMatrix(float[][] elements) {
        float determinant = getDeterminant(elements);
        if (determinant == 0) {
            throw new ArithmeticException("Matrix is not invertible");
        }else {

            float[][] adjMatrix = new float[elements.length][elements.length];

            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix.length; j++) {
                    adjMatrix[i][j] = (float) Math.pow(-1, i + j) * getDeterminant(cutLineAndColumn(elements, i, j));
                }
            }

            return transpose(multiplyScalar(adjMatrix, 1 / determinant));
        }
    }
    /**
     * Транспонирование матрицы.
     * Возвращает матрицу.
     */
    protected static float[][] transpose(float[][] elements) {
        if(elements.length != elements[0].length){
            throw new ArithmeticException("The number of matrix columns is not equal to the number of rows");
        }else {
            float[][] result = new float[elements.length][elements.length];

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[j][i] = elements[i][j];
                }
            }

            return result;
        }
    }
}