package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.mosyakin.Vector3f;


public class Vector3fTest {
    @Test
    void plus(){
        Vector3f vector3f = new Vector3f(2,2,2);
        Vector3f vec = new Vector3f(1,1,1);
        vec = vector3f.plus(vec);
        Assertions.assertEquals(3,vec.getX());
        Assertions.assertEquals(3,vec.getY());
        Assertions.assertEquals(3,vec.getZ());
    }
    @Test
    void plusToThis(){
        Vector3f vector3f = new Vector3f(2,2,2);
        Vector3f vec = new Vector3f(1,1,1);
        vector3f.plusToThis(vec);
        Assertions.assertEquals(3,vector3f.getX());
        Assertions.assertEquals(3,vector3f.getY());
        Assertions.assertEquals(3,vector3f.getZ());
    }
    @Test
    void minus(){
        Vector3f vector3f = new Vector3f(3,3,3);
        Vector3f vec = new Vector3f(1,1,1);
        vec = vector3f.minus(vec);
        Assertions.assertEquals(2,vec.getX());
        Assertions.assertEquals(2,vec.getY());
        Assertions.assertEquals(2,vec.getZ());
    }
    @Test
    void minusFromThis(){
        Vector3f vector3f = new Vector3f(3,3,3);
        Vector3f vec = new Vector3f(1,1,1);
        vector3f.minusFromThis(vec);
        Assertions.assertEquals(2,vector3f.getX());
        Assertions.assertEquals(2,vector3f.getY());
        Assertions.assertEquals(2,vector3f.getZ());
    }
    @Test
    void multiplyThis(){
        Vector3f vector3f = new Vector3f(3,3,3);
        int scalar = 2;
        vector3f.multiplyThis(scalar);
        Assertions.assertEquals(6,vector3f.getX());
        Assertions.assertEquals(6,vector3f.getY());
        Assertions.assertEquals(6,vector3f.getZ());
    }
    @Test
    void multiply(){
        Vector3f vector3f = new Vector3f(3,3,3);
        int scalar = 2;
        Vector3f vec = vector3f.multiply(scalar);
        Assertions.assertEquals(6,vec.getX());
        Assertions.assertEquals(6,vec.getY());
        Assertions.assertEquals(6,vec.getZ());
    }
    @Test
    void divide(){
        Vector3f vector3f = new Vector3f(6,6,6);
        int scalar = 2;
        Vector3f vec = vector3f.divide(scalar);
        Assertions.assertEquals(3,vec.getX());
        Assertions.assertEquals(3,vec.getY());
        Assertions.assertEquals(3,vec.getZ());
        Assertions.assertThrows(NullPointerException.class,()-> vector3f.divide(0));
    }
    @Test
    void divideThis(){
        Vector3f vector3f = new Vector3f(6,6,6);
        int scalar = 2;
        vector3f.divideThis(scalar);
        Assertions.assertEquals(3,vector3f.getX());
        Assertions.assertEquals(3,vector3f.getY());
        Assertions.assertEquals(3,vector3f.getZ());
        Assertions.assertThrows(NullPointerException.class,()-> vector3f.divideThis(0));
    }
    @Test
    void normalize(){
        Vector3f vector3f = new Vector3f(6,6,6);
        Vector3f vec = vector3f.normalize();
        Assertions.assertEquals(0.5773503184318542,vec.getX());
        Assertions.assertEquals(0.5773503184318542,vec.getY());
        Assertions.assertEquals(0.5773503184318542,vec.getZ());
    }
    @Test
    void normalizeThis(){
        Vector3f vector3f = new Vector3f(6,6,6);
        vector3f.normalizeThis();
        Assertions.assertEquals(0.5773503184318542,vector3f.getX());
        Assertions.assertEquals(0.5773503184318542,vector3f.getY());
        Assertions.assertEquals(0.5773503184318542,vector3f.getZ());
    }
    @Test
    void multiplyScalar(){
        Vector3f vector3f = new Vector3f(6,6,6);
        Vector3f vec = new Vector3f(2,2,2);
        float x = vector3f.multiplyScalar(vec);
        Assertions.assertEquals(36,x);
    }
    @Test
    void multiplyVector(){
        Vector3f vector3f = new Vector3f(6,6,6);
        Vector3f vec = new Vector3f(2,2,2);
        vec = vector3f.multiplyVector(vec);
        Assertions.assertEquals(0,vec.getX());
        Assertions.assertEquals(0,vec.getY());
        Assertions.assertEquals(0,vec.getZ());
        vector3f = new Vector3f(1,2,3);
        vec = new Vector3f(3,2,1);
        vec = vector3f.multiplyVector(vec);
        Assertions.assertEquals(-4,vec.getX());
        Assertions.assertEquals(8,vec.getY());
        Assertions.assertEquals(-4,vec.getZ());
    }
}
