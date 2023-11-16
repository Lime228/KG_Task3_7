package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.mosyakin.Matrix3f;
import ru.vsu.cs.mosyakin.Vector3f;


import java.util.Arrays;

public class Matrix3fTest {
    @Test
    void plus() {
        Matrix3f matrix3f = new Matrix3f(new float[][] {{1, 4, 7},
                                                        {2, 5, 8},
                                                        {3, 6, 9}});
        Matrix3f mat = new Matrix3f(new float[][] {{9, 6, 3},
                                                    {8, 5, 2},
                                                    {7, 4, 1}});
        mat = matrix3f.plus(mat);
        Assertions.assertTrue(Arrays.deepEquals(new float[][]{  {10, 10, 10},
                                                                {10, 10, 10},
                                                                {10, 10, 10}}, mat.getMatrix()));
    }

    @Test
    void minus() {
        Matrix3f matrix3f = new Matrix3f(new float[][] {{6, 6, 6},
                                                   {6, 6, 6},
                                                   {6, 6, 6}});
        Matrix3f mat = new Matrix3f(new float[][] {{3, 3, 3},
                                                 {3, 3, 3},
                                                 {3, 3, 3}});
        mat = matrix3f.minus(mat);
        Assertions.assertTrue(Arrays.deepEquals(new float[][]{{3, 3, 3},
                                                                {3, 3, 3},
                                                                 {3, 3, 3}}, mat.getMatrix()));
    }

    @Test
    void multiply() {
        Matrix3f matrix3f = new Matrix3f(new float[][] {{1, 1, 1},
                                                   {2, 2, 2},
                                                   {3, 3, 3}});
        Matrix3f mat = new Matrix3f(new float[][] {{2, 1, 1},
                                                 {1, 2, 1},
                                                 {1, 1, 2}});
        mat = matrix3f.multiply(mat);
        Assertions.assertTrue(Arrays.deepEquals(new float[][]{{4, 4, 4},
                                                              {8, 8, 8},
                                                              {12, 12, 12}}, mat.getMatrix()));
    }

    @Test
    void multiplyVector() {
        Matrix3f matrix3f = new Matrix3f(new float[][] {{1, 1, 1},
                                                   {2, 2, 2},
                                                    {3, 3, 3}});
        Vector3f vector3f = new Vector3f(new float[] {2, 1, 1});
        vector3f = matrix3f.multiply(vector3f);
        Assertions.assertEquals(4,vector3f.getX());
        Assertions.assertEquals(8,vector3f.getY());
        Assertions.assertEquals(12,vector3f.getZ());
    }

    @Test
    void createUnitMatrix() {
        Matrix3f matrix3f = Matrix3f.createUnitMatrix();
        Assertions.assertTrue(Arrays.deepEquals(new float[][]{{1, 0, 0},
                                                                {0, 1, 0},
                                                                {0, 0, 1}}, matrix3f.getMatrix()));
    }

    @Test
    void createNullMatrix() {
        Matrix3f matrix3f = Matrix3f.createNullMatrix();
        Assertions.assertTrue(Arrays.deepEquals(new float[][]{{0, 0, 0},
                                                                {0, 0, 0},
                                                                {0, 0, 0}}, matrix3f.getMatrix()));
    }

    @Test
    void getDeterminant() {
        Matrix3f matrix3f = new Matrix3f(new float[][] {{6, 2, 3},
                                                    {2, 6, 2},
                                                    {3, 2, 6}});
        float determinant = matrix3f.getDeterminant();
        Assertions.assertEquals(138, determinant);
    }

    @Test
    void getInverseMatrix() {
        Matrix3f matrix3f = new Matrix3f(new float[][] {{0, 1, 3},
                                                 {2, 3, 5},
                                                 {3, 5, 7}});
        Matrix3f mat = matrix3f.inverse();
        Assertions.assertTrue(Arrays.deepEquals(new float[][]{{-1, 2, -1},
                                                               {0.25f, -2.25f, 1.5f},
                                                              {0.25f, 0.75f, -0.5f}}, mat.getMatrix()));

        Matrix3f m3f2 = new Matrix3f(new float[][] {{1, 2, 3},
                                                    {4, 5, 6},
                                                    {7, 8, 9}});
        Assertions.assertThrows(ArithmeticException.class, m3f2::inverse);
    }

    @Test
    void transpose() {
        Matrix3f m3f = new Matrix3f(new float[][] {{1, 1, 1},
                                                   {3, 3, 3},
                                                     {6, 6, 6}});
        Matrix3f transpose = m3f.transpose();
        Assertions.assertTrue(Arrays.deepEquals(new float[][]{{1, 3, 6},
                                                             {1, 3, 6},
                                                             {1, 3, 6}}, transpose.getMatrix()));
    }
}
