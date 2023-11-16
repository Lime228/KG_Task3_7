package test;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.mosyakin.Vector2f;

public class Vector2fTest {
    @Test
    void plus(){
        Vector2f vector2f = new Vector2f(2,2);
        Vector2f vec = new Vector2f(1,1);
        vec = vector2f.plus(vec);
        Assertions.assertEquals(3,vec.getX());
        Assertions.assertEquals(3,vec.getY());
    }
    @Test
    void plusToThis(){
        Vector2f vector2f = new Vector2f(2,2);
        Vector2f vec = new Vector2f(1,1);
        vector2f.plusToThis(vec);
        Assertions.assertEquals(3,vector2f.getX());
        Assertions.assertEquals(3,vector2f.getY());
    }
    @Test
    void minus(){
        Vector2f vector2f = new Vector2f(3,3);
        Vector2f vec = new Vector2f(1,1);
        vec = vector2f.minus(vec);
        Assertions.assertEquals(2,vec.getX());
        Assertions.assertEquals(2,vec.getY());
    }
    @Test
    void minusFromThis(){
        Vector2f vector2f = new Vector2f(3,3);
        Vector2f vec = new Vector2f(1,1);
        vector2f.minusFromThis(vec);
        Assertions.assertEquals(2,vector2f.getX());
        Assertions.assertEquals(2,vector2f.getY());
    }
    @Test
    void multiplyThis(){
        Vector2f vector2f = new Vector2f(3,3);
        int scalar = 2;
        vector2f.multiplyThis(scalar);
        Assertions.assertEquals(6,vector2f.getX());
        Assertions.assertEquals(6,vector2f.getY());
    }
    @Test
    void multiply(){
        Vector2f vector2f = new Vector2f(3,3);
        int scalar = 2;
        Vector2f vec = vector2f.multiply(scalar);
        Assertions.assertEquals(6,vec.getX());
        Assertions.assertEquals(6,vec.getY());
    }
    @Test
    void divide(){
        Vector2f vector2f = new Vector2f(6,6);
        int scalar = 2;
        Vector2f vec = vector2f.divide(scalar);
        Assertions.assertEquals(3,vec.getX());
        Assertions.assertEquals(3,vec.getY());
        Assertions.assertThrows(NullPointerException.class,()-> vector2f.divide(0));
    }
    @Test
    void divideThis(){
        Vector2f vector2f = new Vector2f(6,6);
        int scalar = 2;
        vector2f.divideThis(scalar);
        Assertions.assertEquals(3,vector2f.getX());
        Assertions.assertEquals(3,vector2f.getY());
        Assertions.assertThrows(NullPointerException.class,()-> vector2f.divideThis(0));
    }
    @Test
    void normalize(){
        Vector2f vector2f = new Vector2f(6,6);
        Vector2f vec = vector2f.normalize();
        Assertions.assertEquals(0.7071068286895752,vec.getX());
        Assertions.assertEquals(0.7071068286895752,vec.getY());
    }
    @Test
    void normalizeThis(){
        Vector2f vector2f = new Vector2f(6,6);
        vector2f.normalizeThis();
        Assertions.assertEquals(0.7071068286895752,vector2f.getX());
        Assertions.assertEquals(0.7071068286895752,vector2f.getY());
    }
    @Test
    void multiplyScalar(){
        Vector2f vector2f = new Vector2f(6,6);
        Vector2f vec = new Vector2f(2,2);
        float x = vector2f.multiplyScalar(vec);
        Assertions.assertEquals(24,x);
    }
}
