package ru.vsu.cs.mosyakin;
/**
 * Класс матрицы размерности 3.
 * @version 1.0
 */
public class Matrix3f {
    /**
     * Поле размер.
     */
    private static final int size = 3;
    /**
     * Поле элементов матрицы.
     */
    private float[][] elements = new float[size][size];
    /**
     * Конструктор матрицы через двумерный массив float.
     */
    public Matrix3f(float[][] elements) {
        this.elements = elements;
    }
    /**
     * Конструктор матрицы через другую матрицу Matrix3f.
     */
    public Matrix3f(Matrix3f matrix) {
        this.elements = matrix.elements;
    }
    /**
     * Сложение матриц.
     * Возвращает матрицу.
     */
    public Matrix3f add(Matrix3f input) {
        return new Matrix3f(MatrixOperations.add(this.elements, input.elements));
    }
    /**
     * Сложение матриц.
     * Сложение остается в матрице, от которой вызывается.
     */
    public void addToThis(Matrix3f input) {
        setMatrix(new Matrix3f(MatrixOperations.add(this.elements, input.elements)));
    }
    /**
     * Вычитание матриц.
     * Возвращает матрицу.
     */
    public Matrix3f subtract(Matrix3f input) {
        return new Matrix3f(MatrixOperations.subtract(this.elements, input.elements));
    }
    /**
     * Вычитание матриц.
     * Вычитание остается в матрице, от которой вызывается.
     */
    public void subtractFromThis(Matrix3f input) {
        setMatrix(new Matrix3f(MatrixOperations.subtract(this.elements, input.elements)));
    }
    /**
     * Умножение матрицы на вектор.
     * Возвращает вектор.
     */
    public Vector3f multiply(Vector3f vector) {
        float[] returnVector = MatrixOperations.multiply(this.elements, new float [] {vector.getX(), vector.getY(), vector.getZ()});
        return new Vector3f(returnVector[0], returnVector[1], returnVector[2]);
    }
    /**
     * Умножение матриц.
     * Возвращает матрицу.
     */
    public Matrix3f multiply(Matrix3f input) {
        return new Matrix3f(MatrixOperations.multiply(this.elements, input.elements));
    }
    /**
     * Умножение матриц.
     * Умножение остается в матрице, от которой вызывается.
     */
    public void multiplyThis(Matrix3f input) {
        setMatrix(new Matrix3f(MatrixOperations.multiply(this.elements, input.elements)));
    }
    /**
     * Создание единичной матрицы.
     * Возвращает матрицу.
     */
    public static Matrix3f createUnitMatrix() {
        return new Matrix3f(MatrixOperations.createUnitMatrix(size));
    }
    /**
     * Создание нулевой матрицы.
     * Возвращает матрицу.
     */
    public static Matrix3f createNullMatrix() {
        return new Matrix3f(MatrixOperations.createNullMatrix(size));
    }
    /**
     * Нахождение определителя матрицы, от которой вызывается.
     * Возвращает определитель.
     */
    public float getDeterminant() {
        return MatrixOperations.getDeterminant(elements);
    }
    /**
     * Создание обратной матрицы.
     * Возвращает матрицу.
     */
    public Matrix3f inverse() {
        return new Matrix3f(MatrixOperations.inverseMatrix(this.elements));
    }
    /**
     * Создание обратной матрицы.
     * Замещает матрицу, от которой вызывается.
     */
    public void inverseThis() {
        setMatrix(new Matrix3f(MatrixOperations.inverseMatrix(this.elements)));
    }
    /**
     * Транспонирование матрицы.
     * Возвращает матрицу.
     */
    public Matrix3f transpose() {
        return new Matrix3f(MatrixOperations.transpose(this.elements));
    }
    /**
     * Транспонирование матрицы.
     * Замещает матрицу, от которой вызывается.
     */
    public void transposeThis() {
        setMatrix(new Matrix3f(MatrixOperations.transpose(this.elements)));
    }
    /**
     * Замещает матрицу, от которой вызывается, на переданный двумерный массив размерности 3.
     */
    public void setMatrix(float[][] matrix) {
        this.elements = matrix;
    }
    /**
     * Замещает матрицу, от которой вызывается, на переданную матрицу Matrix3f.
     */
    public void setMatrix(Matrix3f matrix){
        this.elements = matrix.elements;
    }
    /**
     * Возвращает элементы матрицы.
     */
    public float[][] getMatrix() {
        return elements;
    }
}