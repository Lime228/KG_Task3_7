package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.mosyakin.Matrix4f;
import ru.vsu.cs.mosyakin.Vector4f;

import java.util.Arrays;

public class Matrix4fTest {
    @Test
    void plus() {
        Matrix4f matrix4f = new Matrix4f(new float[][] {{4, 4, 4, 4},
                                                        {4, 4, 4, 4},
                                                        {4, 4, 4, 4},
                                                        {4, 4, 4, 4}});
        Matrix4f mat = new Matrix4f(new float[][] {{2, 2, 2, 2},
                                                   {2, 2, 2, 2},
                                                   {2, 2, 2, 2},
                                                   {2, 2, 2, 2}});
        mat = matrix4f.plus(mat);
        Assertions.assertTrue(Arrays.deepEquals(new float[][]{{6, 6, 6, 6},
                                                              {6, 6, 6, 6},
                                                              {6, 6, 6, 6},
                                                              {6, 6, 6, 6}}, mat.getMatrix()));

    }

    @Test
    void minus() {
        Matrix4f matrix4f = new Matrix4f(new float[][] {{6, 6, 6, 6},
                                                    {6, 6, 6, 6},
                                                    {6, 6, 6, 6},
                                                    {6, 6, 6, 6}});
        Matrix4f mat = new Matrix4f(new float[][] {{4, 4, 4, 4},
                                                  {4, 4, 4, 4},
                                                  {4, 4, 4, 4},
                                                  {4, 4, 4, 4}});
        mat = matrix4f.minus(mat);
        Assertions.assertTrue(Arrays.deepEquals(new float[][]{{2, 2, 2, 2},
                                                              {2, 2, 2, 2},
                                                              {2, 2, 2, 2},
                                                              {2, 2, 2, 2}}, mat.getMatrix()));

    }

    @Test
    void multiply() {
        Matrix4f matrix4f = new Matrix4f(new float[][] {{1, 1, 1, 1},
                                                        {3, 3, 3, 3},
                                                        {6, 6, 6, 6},
                                                        {9, 9, 9, 9}});
        Matrix4f mat = new Matrix4f(new float[][] {{9, 9, 9, 9},
                                                    {6, 6, 6, 6},
                                                    {3, 3, 3, 3},
                                                    {1, 1, 1, 1}});
        mat = matrix4f.multiply(mat);
        Assertions.assertTrue(Arrays.deepEquals(new float[][]{{19, 19, 19, 19},
                                                                {57, 57, 57, 57},
                                                                {114, 114, 114, 114},
                                                                {171, 171, 171, 171}}, mat.getMatrix()));
    }

    @Test
    void multiplyVector() {
        Matrix4f matrix4f = new Matrix4f(new float[][] {{1, 1, 1, 1},
                                                    {3, 3, 3, 3},
                                                    {6, 6, 6, 6},
                                                    {9, 9, 9, 9}});
        Vector4f vector4f = new Vector4f(new float[] {6, 6, 6, 6});
        Vector4f result = matrix4f.multiply(vector4f);
        Assertions.assertEquals(24, result.getX());
        Assertions.assertEquals(72, result.getY());
        Assertions.assertEquals(144, result.getZ());
        Assertions.assertEquals(216, result.getW());
    }

    @Test
    void createUnitMatrix() {
        Matrix4f matrix4f = Matrix4f.createUnitMatrix();
        Assertions.assertTrue(Arrays.deepEquals(new float[][]{{1, 0, 0, 0},
                                                                {0, 1, 0, 0},
                                                                {0, 0, 1, 0},
                                                                {0, 0, 0, 1}}, matrix4f.getMatrix()));
    }

    @Test
    void createNullMatrix() {
        Matrix4f matrix4f = Matrix4f.createNullMatrix();
        Assertions.assertTrue(Arrays.deepEquals(new float[][]{{0, 0, 0, 0},
                                                                {0, 0, 0, 0},
                                                                 {0, 0, 0, 0},
                                                                {0, 0, 0, 0}}, matrix4f.getMatrix()));
    }

    @Test
    void getDeterminant() {
        Matrix4f matrix4f = new Matrix4f(new float[][] {{6, 2, 3, 9},
                                                    {2, 6, 2, 3},
                                                    {3, 2, 6, 2},
                                                    {9, 3, 2, 6}});
        float determinant = matrix4f.getDeterminant();
        Assertions.assertEquals(-1235, determinant);
    }

    @Test
    void getInverseMatrix() {
        Matrix4f matrix4f = new Matrix4f(new float[][] {{0, 1, 3, 1},
                                                    {2, 3, 5, 1},
                                                    {3, 5, 7, 2},
                                                    {1, 1, 1, 2}});

        Assertions.assertTrue(Arrays.deepEquals(new float[][]{{-0.75f, 1.75f, -1, 0.5f},
                                                                {0, -2, 1.5f, -0.5f},
                                                                {0.25f, 0.75f, -0.5f, 0},
                                                                {0.25f, -0.25f, 0, 0.5f}}, matrix4f.inverse().getMatrix()));

        Matrix4f mat = new Matrix4f(new float[][] {{1, 2, 3, 4},
                                                    {5, 6, 7, 8},
                                                    {9, 10, 11, 12},
                                                    {13, 14, 15, 16}});
        Assertions.assertThrows(ArithmeticException.class, mat::inverse);
    }

    @Test
    void transpose() {
        Matrix4f matrix4f = new Matrix4f(new float[][] {{1, 1, 1, 1},
                                                    {3, 3, 3, 3},
                                                    {6, 6, 6, 6},
                                                    {9, 9, 9, 9}});
        Matrix4f mat = matrix4f.transpose();
        Assertions.assertTrue(Arrays.deepEquals(new float[][]{{1, 3, 6, 9},
                                                                {1, 3, 6, 9},
                                                                {1, 3, 6, 9},
                                                                {1, 3, 6, 9}}, mat.getMatrix()));
    }
}