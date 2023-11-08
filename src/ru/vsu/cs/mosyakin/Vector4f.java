package ru.vsu.cs.mosyakin;

import java.util.ArrayList;
/**
 * Класс вектора размерности 4.
 * @autor Владимир Мосякин
 * @version 1.0
 */
public class Vector4f {
    /** Поле х. */
    private float x;
    /** Поле y. */
    private float y;
    /** Поле z. */
    private float z;
    /** Поле w. */
    private float w;
    /** Поле длинна. */
    private float length;
    /** Конструктор вектора по значениям х и y. */
    public Vector4f(float x, float y, float z, float w){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.length = (float) Math.sqrt((x*x) + (y*y) + (z*z) + (w*w));
    }
    /** Конструктор вектора из другого вектора. */
    public Vector4f(Vector4f vector4f){
        this.x = vector4f.x;
        this.y = vector4f.y;
        this.z = vector4f.z;
        this.w = vector4f.w;
        this.length = vector4f.getLength();
    }
    /** Конструктор вектора по значениям массива float. */
    public Vector4f(float[] floats){
        if (floats.length < 4) {
            throw new NullPointerException("Exception: massive don't have 4 elements!");
        } else {
            this.x = floats[0];
            this.y = floats[1];
            this.z = floats[2];
            this.w = floats[3];
            this.length = (float) Math.sqrt((floats[0] * floats[0]) + (floats[1] * floats[1]) + (floats[2] * floats[2]) + (floats[3] * floats[3]));
        }
    }
    /** Конструктор вектора по значениям листа float. */
    public Vector4f(ArrayList<Float> floats){
        if (floats.size() < 4) {
            throw new NullPointerException("Exception: list don't have 3 elements!");
        } else {
            this.x = floats.get(0);
            this.y = floats.get(1);
            this.z = floats.get(2);
            this.w = floats.get(3);
            this.length = (float) Math.sqrt((floats.get(0) * floats.get(0)) + (floats.get(1) * floats.get(1))+ (floats.get(2) * floats.get(2))+ (floats.get(3) * floats.get(3)));
        }
    }
    /** Сложение двух векторов.
     * Возвращает новый вектор.
     * */
    public Vector4f add(Vector4f vector4f){
        return new Vector4f(this.x + vector4f.getX(), this.y + vector4f.getY(), this.z + vector4f.getZ(), this.w + vector4f.getW());
    }
    /** Сложение двух векторов.
     * Сложение остается в векторе, от которого вызывается.
     * */
    public void addToThis(Vector4f vector4f){
        this.x += vector4f.getX();
        this.y += vector4f.getY();
        this.z += vector4f.getZ();
        this.w += vector4f.getW();
        this.length = (float) Math.sqrt((x*x)+(y*y)+(z*z)+(w*w));
    }
    /** Вычитание двух векторов.
     * Возвращает новый вектор.
     * */
    public Vector4f subtract(Vector4f vector4f) {
        return new Vector4f(this.x - vector4f.getX(), this.y - vector4f.getY(), this.z - vector4f.getZ(), this.w - vector4f.getW());
    }
    /** Вычитание двух векторов.
     * Вычитание остается в векторе, от которого вызывается.
     * */
    public void subtractFromThis(Vector4f vector4f){
        this.x -= vector4f.getX();
        this.y -= vector4f.getY();
        this.z -= vector4f.getZ();
        this.w -= vector4f.getW();
        this.length = (float) Math.sqrt((x*x)+(y*y)+(z*z)+(w*w));
    }
    /** Умножение вектора на скаляр.
     * Возвращает новый вектор.
     * */
    public Vector4f multiply(float scalar) {
        return new Vector4f(this.x * scalar, this.y * scalar, this.z * scalar, this.w * scalar);
    }
    /** Умножение вектора на скаляр.
     * Умножение остается в векторе, от которого вызывается.
     * */
    public void multiplyThis(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        this.w *= scalar;
        this.length = (float) Math.sqrt((x*x)+(y*y)+(z*z)+(w*w));
    }
    /** Деление вектора на скаляр.
     * Возвращает новый вектор.
     * */
    public Vector4f divide(float scalar) {
        if (scalar == 0) {
            throw new NullPointerException("Exception: scalar is null!");
        } else {
            return new Vector4f(this.x / scalar, this.y / scalar, this.z / scalar, this.w / scalar);
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
            this.w /= scalar;
            this.length = (float) Math.sqrt((x*x)+(y*y)+(z*z)+(w*w));
        }
    }
    /** Нормализация вектора.
     * Возвращает новый вектор.
     * */
    public Vector4f normalization() {
        return new Vector4f(this.x / length, this.y / length, this.z / length, this.w / length);
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
            this.w /= length;
            this.length = (float) Math.sqrt((x * x) + (y * y) + (z * z)+(w*w));
        }
    }
    /** Скалярное умножение векторов.
     * */
    public float multiplyScalar(Vector4f vector) {
        return this.x * vector.getX() + this.y * vector.getY() + this.z * vector.getZ() + this.w * vector.getW();
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
    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }
}
