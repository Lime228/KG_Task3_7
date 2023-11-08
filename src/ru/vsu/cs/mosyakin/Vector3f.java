package ru.vsu.cs.mosyakin;

import java.util.ArrayList;
/**
 * Класс вектора размерности 3.
 * @autor Владимир Мосякин
 * @version 1.0
 */
public class Vector3f {
    /** Поле х. */
    private float x;
    /** Поле y. */
    private float y;
    /** Поле z. */
    private float z;
    /** Поле длинна. */
    private float length;
    /** Конструктор вектора по значениям х и y. */
    public Vector3f(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.length = (float) Math.sqrt((x*x) + (y*y) + (z*z));
    }
    /** Конструктор вектора из другого вектора. */
    public Vector3f(Vector3f vector3f){
        this.x = vector3f.x;
        this.y = vector3f.y;
        this.z = vector3f.z;
        this.length = vector3f.getLength();
    }
    /** Конструктор вектора по значениям массива float. */
    public Vector3f(float[] floats){
        if (floats.length < 3) {
            throw new NullPointerException("Exception: massive don't have 3 elements!");
        } else {
            this.x = floats[0];
            this.y = floats[1];
            this.z = floats[2];
            this.length = (float) Math.sqrt((floats[0] * floats[0]) + (floats[1] * floats[1]) + (floats[2] * floats[2]));
        }
    }
    /** Конструктор вектора по значениям листа float. */
    public Vector3f(ArrayList<Float> floats){
        if (floats.size() < 3) {
            throw new NullPointerException("Exception: list don't have 3 elements!");
        } else {
            this.x = floats.get(0);
            this.y = floats.get(1);
            this.z = floats.get(2);
            this.length = (float) Math.sqrt((floats.get(0) * floats.get(0)) + (floats.get(1) * floats.get(1))+ (floats.get(2) * floats.get(2)));
        }
    }
    /** Сложение двух векторов.
     * Возвращает новый вектор.
     * */
    public Vector3f add(Vector3f vector3f){
        return new Vector3f(this.x + vector3f.getX(), this.y + vector3f.getY(), this.z + vector3f.getZ());
    }
    /** Сложение двух векторов.
     * Сложение остается в векторе, от которого вызывается.
     * */
    public void addToThis(Vector3f vector3f){
        this.x += vector3f.getX();
        this.y += vector3f.getY();
        this.z += vector3f.getZ();
        this.length = (float) Math.sqrt((x*x)+(y*y)+(z*z));
    }
    /** Вычитание двух векторов.
     * Возвращает новый вектор.
     * */
    public Vector3f subtract(Vector3f vector3f) {
        return new Vector3f(this.x - vector3f.getX(), this.y - vector3f.getY(), this.z - vector3f.getZ());
    }
    /** Вычитание двух векторов.
     * Вычитание остается в векторе, от которого вызывается.
     * */
    public void subtractFromThis(Vector3f vector3f){
        this.x -= vector3f.getX();
        this.y -= vector3f.getY();
        this.z -= vector3f.getZ();
        this.length = (float) Math.sqrt((x*x)+(y*y)+(z*z));
    }
    /** Умножение вектора на скаляр.
     * Возвращает новый вектор.
     * */
    public Vector3f multiply(float scalar) {
        return new Vector3f(this.x * scalar, this.y * scalar, this.z * scalar);
    }
    /** Умножение вектора на скаляр.
     * Умножение остается в векторе, от которого вызывается.
     * */
    public void multiplyThis(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        this.length = (float) Math.sqrt((x*x)+(y*y)+(z*z));
    }
    /** Деление вектора на скаляр.
     * Возвращает новый вектор.
     * */
    public Vector3f divide(float scalar) {
        if (scalar == 0) {
            throw new NullPointerException("Exception: scalar is null!");
        } else {
            return new Vector3f(this.x / scalar, this.y / scalar, this.z / scalar);
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
            this.z /= scalar;
            this.length = (float) Math.sqrt((x*x)+(y*y)+(z*z));
        }
    }
    /** Нормализация вектора.
     * Возвращает новый вектор.
     * */
    public Vector3f normalization() {
        return new Vector3f(this.x / length, this.y / length, this.z / length);
    }
    /** Нормализация вектора.
     * Нормализация остается в векторе, от которого вызывается.
     * */
    public void normalizationThis() {
        if (length == 0) {
            throw new NullPointerException("Exception: scalar is null!");
        }else {
            this.x /= length;
            this.y /= length;
            this.z /= length;
            this.length = (float) Math.sqrt((x * x) + (y * y) + (z * z));
        }
    }
    /** Скалярное умножение векторов.
     * */
    public float multiplyScalar(Vector3f vector) {
        return this.x * vector.getX() + this.y * vector.getY() + this.z * vector.getZ();
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
    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }
}