package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.mosyakin.Vector4f;

public class Vector4fTest {
    @Test
    void plus(){
        Vector4f vector4f = new Vector4f(2,2,2,2);
        Vector4f vec = new Vector4f(1,1,1,1);
        vec = vector4f.plus(vec);
        Assertions.assertEquals(3,vec.getX());
        Assertions.assertEquals(3,vec.getY());
        Assertions.assertEquals(3,vec.getZ());
        Assertions.assertEquals(3,vec.getW());
    }
    @Test
    void plusToThis(){
        Vector4f vector4f = new Vector4f(2,2,2,2);
        Vector4f vec = new Vector4f(1,1,1,1);
        vector4f.plusToThis(vec);
        Assertions.assertEquals(3,vector4f.getX());
        Assertions.assertEquals(3,vector4f.getY());
        Assertions.assertEquals(3,vector4f.getZ());
        Assertions.assertEquals(3,vector4f.getW());
    }
    @Test
    void minus(){
        Vector4f vector4f = new Vector4f(3,3,3,3);
        Vector4f vec = new Vector4f(1,1,1,1);
        vec = vector4f.minus(vec);
        Assertions.assertEquals(2,vec.getX());
        Assertions.assertEquals(2,vec.getY());
        Assertions.assertEquals(2,vec.getZ());
        Assertions.assertEquals(2,vec.getW());
    }
    @Test
    void minusFromThis(){
        Vector4f vector4f = new Vector4f(3,3,3,3);
        Vector4f vec = new Vector4f(1,1,1,1);
        vector4f.minusFromThis(vec);
        Assertions.assertEquals(2,vector4f.getX());
        Assertions.assertEquals(2,vector4f.getY());
        Assertions.assertEquals(2,vector4f.getZ());
        Assertions.assertEquals(2,vector4f.getW());
    }
    @Test
    void multiplyThis(){
        Vector4f vector4f = new Vector4f(3,3,3,3);
        int scalar = 2;
        vector4f.multiplyThis(scalar);
        Assertions.assertEquals(6,vector4f.getX());
        Assertions.assertEquals(6,vector4f.getY());
        Assertions.assertEquals(6,vector4f.getZ());
        Assertions.assertEquals(6,vector4f.getW());
    }
    @Test
    void multiply(){
        Vector4f vector4f = new Vector4f(3,3,3,3);
        int scalar = 2;
        Vector4f vec = vector4f.multiply(scalar);
        Assertions.assertEquals(6,vec.getX());
        Assertions.assertEquals(6,vec.getY());
        Assertions.assertEquals(6,vec.getZ());
        Assertions.assertEquals(6,vec.getW());
    }
    @Test
    void divide(){
        Vector4f vector4f = new Vector4f(6,6,6,6);
        int scalar = 2;
        Vector4f vec = vector4f.divide(scalar);
        Assertions.assertEquals(3,vec.getX());
        Assertions.assertEquals(3,vec.getY());
        Assertions.assertEquals(3,vec.getZ());
        Assertions.assertEquals(3,vec.getW());
        Assertions.assertThrows(NullPointerException.class,()-> vector4f.divide(0));
    }
    @Test
    void divideThis(){
        Vector4f vector4f = new Vector4f(6,6,6,6);
        int scalar = 2;
        vector4f.divideThis(scalar);
        Assertions.assertEquals(3,vector4f.getX());
        Assertions.assertEquals(3,vector4f.getY());
        Assertions.assertEquals(3,vector4f.getZ());
        Assertions.assertEquals(3,vector4f.getW());
        Assertions.assertThrows(NullPointerException.class,()-> vector4f.divideThis(0));
    }
    @Test
    void normalize(){
        Vector4f vector4f = new Vector4f(6,6,6,6);
        Vector4f vec = vector4f.normalize();
        Assertions.assertEquals(0.5,vec.getX());
        Assertions.assertEquals(0.5,vec.getY());
        Assertions.assertEquals(0.5,vec.getZ());
        Assertions.assertEquals(0.5,vec.getW());
    }
    @Test
    void normalizeThis(){
        Vector4f vector4f = new Vector4f(6,6,6,6);
        vector4f.normalizeThis();
        Assertions.assertEquals(0.5,vector4f.getX());
        Assertions.assertEquals(0.5,vector4f.getY());
        Assertions.assertEquals(0.5,vector4f.getZ());
        Assertions.assertEquals(0.5,vector4f.getW());
    }
    @Test
    void multiplyScalar(){
        Vector4f vector4f = new Vector4f(6,6,6,6);
        Vector4f vec = new Vector4f(2,2,2,2);
        float x = vector4f.multiplyScalar(vec);
        Assertions.assertEquals(48,x);
    }
}
