package demo.parallel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexTest {

  private static final double DELTA = 1e-9; // Погрешность для сравнения double

  @Test
  void testSubtract() {
    Complex a = new Complex(5, 10);
    Complex b = new Complex(3, 4);
    a.subtract(b);
    assertEquals(2.0, a.getRe(), DELTA, "Real part should be 5-3=2");
    assertEquals(6.0, a.getIm(), DELTA, "Imaginary part should be 10-4=6");
  }

  @Test
  void testPow_Zero() {
    Complex a = new Complex(5, 10);
    a.pow(0);
    assertEquals(1.0, a.getRe(), DELTA, "Real part of c^0 should be 1");
    assertEquals(0.0, a.getIm(), DELTA, "Imaginary part of c^0 should be 0");
  }

  @Test
  void testPow_One() {
    Complex a = new Complex(5, 10);
    a.pow(1);
    assertEquals(5.0, a.getRe(), DELTA, "Real part of c^1 should be unchanged");
    assertEquals(10.0, a.getIm(), DELTA, "Imaginary part of c^1 should be unchanged");
  }

  @Test
  void testPow_Two() {
    Complex a = new Complex(2, 3); // (2+3i)^2 = 4 + 12i + 9i^2 = 4 - 9 + 12i = -5 + 12i
    a.pow(2);
    assertEquals(-5.0, a.getRe(), DELTA, "Real part of (2+3i)^2 should be -5");
    assertEquals(12.0, a.getIm(), DELTA, "Imaginary part of (2+3i)^2 should be 12");
  }

  @Test
  void testPow_Three() {
    Complex a = new Complex(2, 1); // (2+i)^3 = (2+i)*(4+4i-1) = (2+i)*(3+4i) = 6+8i+3i-4 = 2+11i
    a.pow(3);
    assertEquals(2.0, a.getRe(), DELTA, "Real part of (2+i)^3 should be 2");
    assertEquals(11.0, a.getIm(), DELTA, "Imaginary part of (2+i)^3 should be 11");
  }

  @Test
  void testCopy() {
    Complex original = new Complex(10, 20);
    Complex copied = original.copy();

    assertNotSame(original, copied, "Copied object should be a new instance");
    assertEquals(original.getRe(), copied.getRe(), DELTA, "Real parts should be equal");
    assertEquals(original.getIm(), copied.getIm(), DELTA, "Imaginary parts should be equal");

    // Проверяем, что изменение копии не влияет на оригинал
    copied.plus(new Complex(1,1));
    assertEquals(10, original.getRe(), DELTA, "Original real part should not change");
    assertEquals(20, original.getIm(), DELTA, "Original imaginary part should not change");
  }
}