package ru.vsu.cs.mosyakin;
/**
 * Класс матрицы размерности 4.
 * @version 1.0
 */
public class Matrix4f {
    /**
     * Поле размер.
     */
    private static final int size = 4;
    /**
     * Поле элементов матрицы.
     */
    private float[][] elements = new float[size][size];
    /**
     * Конструктор матрицы через двумерный массив float.
     */
    public Matrix4f(float[][] elements) {
        this.elements = elements;
    }
    /**
     * Конструктор матрицы через другую матрицу Matrix4f.
     */
    public Matrix4f(Matrix4f matrix) {
        this.elements = matrix.elements;
    }
    /**
     * Сложение матриц.
     * Возвращает матрицу.
     */
    public Matrix4f add(Matrix4f input) {
        return new Matrix4f(MatrixOperations.add(this.elements, input.elements));
    }
    /**
     * Сложение матриц.
     * Сложение остается в матрице, от которой вызывается.
     */
    public void addToThis(Matrix4f input) {
        setMatrix(new Matrix4f(MatrixOperations.add(this.elements, input.elements)));
    }
    /**
     * Вычитание матриц.
     * Возвращает матрицу.
     */
    public Matrix4f subtract(Matrix4f input) {
        return new Matrix4f(MatrixOperations.subtract(this.elements, input.elements));
    }
    /**
     * Вычитание матриц.
     * Вычитание остается в матрице, от которой вызывается.
     */
    public void subtractFromThis(Matrix4f input) {
        setMatrix(new Matrix4f(MatrixOperations.subtract(this.elements, input.elements)));
    }
    /**
     * Умножение матрицы на вектор.
     * Возвращает вектор.
     */
    public Vector4f multiply(Vector4f vector) {
        float[] returnVector = MatrixOperations.multiply(this.elements, new float [] {vector.getX(), vector.getY(), vector.getZ(), vector.getW()});
        return new Vector4f(returnVector[0], returnVector[1], returnVector[2],returnVector[3]);
    }
    /**
     * Умножение матриц.
     * Возвращает матрицу.
     */
    public Matrix4f multiply(Matrix4f input) {
        return new Matrix4f(MatrixOperations.multiply(this.elements, input.elements));
    }
    /**
     * Умножение матриц.
     * Умножение остается в матрице, от которой вызывается.
     */
    public void multiplyThis(Matrix4f input) {
        setMatrix(new Matrix4f(MatrixOperations.multiply(this.elements, input.elements)));
    }
    /**
     * Создание единичной матрицы.
     * Возвращает матрицу.
     */
    public static Matrix4f createUnitMatrix() {
        return new Matrix4f(MatrixOperations.createUnitMatrix(size));
    }
    /**
     * Создание нулевой матрицы.
     * Возвращает матрицу.
     */
    public static Matrix4f createNullMatrix() {
        return new Matrix4f(MatrixOperations.createNullMatrix(size));
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
    public Matrix4f inverse() {
        return new Matrix4f(MatrixOperations.inverseMatrix(this.elements));
    }
    /**
     * Создание обратной матрицы.
     * Замещает матрицу, от которой вызывается.
     */
    public void inverseThis() {
        setMatrix(new Matrix4f(MatrixOperations.inverseMatrix(this.elements)));
    }
    /**
     * Транспонирование матрицы.
     * Возвращает матрицу.
     */
    public Matrix4f transpose() {
        return new Matrix4f(MatrixOperations.transpose(this.elements));
    }
    /**
     * Транспонирование матрицы.
     * Замещает матрицу, от которой вызывается.
     */
    public void transposeThis() {
        setMatrix(new Matrix4f(MatrixOperations.transpose(this.elements)));
    }
    /**
     * Замещает матрицу, от которой вызывается, на переданный двумерный массив размерности 4.
     */
    public void setMatrix(float[][] matrix) {
        this.elements = matrix;
    }
    /**
     * Замещает матрицу, от которой вызывается, на переданную матрицу Matrix4f.
     */
    public void setMatrix(Matrix4f matrix){
        this.elements = matrix.elements;
    }
    /**
     * Возвращает элементы матрицы.
     */
    public float[][] getMatrix() {
        return elements;
    }
}