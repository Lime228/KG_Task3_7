package ru.vsu.cs.mosyakin;

import java.util.ArrayList;
/**
 * Класс вектора размерности 2.
 * @version 1.2
 */
public class Vector2f {
    /** Поле х. */
    private float x;
    /** Поле y. */
    private float y;
    /** Поле длинна. */
    private float length;
    /** Конструктор вектора по значениям х и y. */
    public Vector2f(float x, float y){
        this.x = x;
        this.y = y;
        this.length = (float) Math.sqrt((x*x)+(y*y));
    }
    /** Конструктор вектора из другого вектора. */
    public Vector2f(Vector2f vector2f){
        this.x = vector2f.getX();
        this.y = vector2f.getY();
        this.length = vector2f.getLength();
    }
    /** Конструктор вектора по значениям массива float. */
    public Vector2f(float[] floats){
        if (floats.length < 2) {
            throw new NullPointerException("Exception: massive don't have 2 elements!");
        } else {
            this.x = floats[0];
            this.y = floats[1];
            this.length = (float) Math.sqrt((floats[0] * floats[0]) + (floats[1] * floats[1]));
        }
    }
    /** Конструктор вектора по значениям листа float. */
    public Vector2f(ArrayList<Float> floats){
        if (floats.size() < 2) {
            throw new NullPointerException("Exception: list don't have 2 elements!");
        } else {
            this.x = floats.get(0);
            this.y = floats.get(1);
            this.length = (float) Math.sqrt((floats.get(0) * floats.get(0)) + (floats.get(1) * floats.get(1)));
        }
    }
    /** Сложение двух векторов.
     * Возвращает новый вектор.
     * */
    public Vector2f plus(Vector2f vector2f){
        return new Vector2f(this.x + vector2f.getX(), this.y + vector2f.getY());
    }
    /** Сложение двух векторов.
     * Сложение остается в векторе, от которого вызывается.
     * */
    public void plusToThis(Vector2f vector2f){
        this.x += vector2f.getX();
        this.y += vector2f.getY();
        this.length = (float) Math.sqrt((x*x)+(y*y));
    }
    /** Вычитание двух векторов.
     * Возвращает новый вектор.
     * */
    public Vector2f minus(Vector2f vector2f) {
        return new Vector2f(this.x - vector2f.x, this.y - vector2f.y);
    }
    /** Вычитание двух векторов.
     * Вычитание остается в векторе, от которого вызывается.
     * */
    public void minusFromThis(Vector2f vector2f){
        this.x -= vector2f.getX();
        this.y -= vector2f.getY();
        this.length = (float) Math.sqrt((x*x)+(y*y));
    }
    /** Умножение вектора на скаляр.
     * Возвращает новый вектор.
     * */
    public Vector2f multiply(float scalar) {
        return new Vector2f(this.x * scalar, this.y * scalar);
    }
    /** Умножение вектора на скаляр.
     * Умножение остается в векторе, от которого вызывается.
     * */
    public void multiplyThis(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.length = (float) Math.sqrt((x*x)+(y*y));
    }
    /** Деление вектора на скаляр.
     * Возвращает новый вектор.
     * */
    public Vector2f divide(float scalar) {
        if (scalar == 0) {
            throw new NullPointerException("Exception: scalar is null!");
        } else {
            return new Vector2f(this.x / scalar, this.y / scalar);
        }
    }
    /** Деление вектора на скаляр.
     * Деление остается в векторе, от которого вызывается.
     * */
    public void divideThis(float scalar) {
        if (scalar == 0) {
            throw new NullPointerException("Exception: scalar is null!");
        } else {
            this.x /= scalar;
            this.y /= scalar;
            this.length = (float) Math.sqrt((x*x)+(y*y));
        }
    }
    /** Нормализация вектора.
     * Возвращает новый вектор.
     * */
    public Vector2f normalize() {
        return this.divide(length);
    }
    /** Нормализация вектора.
     * Нормализация остается в векторе, от которого вызывается.
     * */
    public void normalizeThis() {
        divideThis(length);
    }
    /** Скалярное умножение векторов.
     * */
    public float multiplyScalar(Vector2f vector) {
        return this.x * vector.x + this.y * vector.y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }
}