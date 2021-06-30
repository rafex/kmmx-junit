package mx.kmmx.junit5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import mx.kmmx.junit5.Math;

public class MathTest {

  @Test
  @Tag("sum")
  @DisplayName("La suma de dos numeros enteros")
  void sumaDeEnteros() {
    final Math math = new Math();
    final Integer a = 3;
    final Integer b = 5;
    final Integer expected = 8;
    final Integer result = math.sum(a, b);

    assertEquals(expected, result);
  }

  @Test
  @Tag("div")
  @DisplayName("otro caso de prueba")
  void divideTest2() {
    final Math math = new Math();
    final Double a = 6.0;
    final Double b = 3.0;
    final Double expected = 2.0;
    assertEquals(expected, math.divide(a, b));

  }

  @Test
  @DisplayName("otro caso de prueba")
  void divideTest() {
    final Math math = new Math();
    final Double a = 3.0;
    final Double b = 0.0;
    final Double expected = 0.0;
    assertThrows(ArithmeticException.class, () -> {
      final Double result = math.divide(a, b);
    });
  }

  @Test
  @DisplayName("otro caso de prueba ...")
  void divideTest3() {
    final Math math = new Math();
    final Double a = 3.0;
    final Double b = -5.0;
    final Double expected = 0.0;
    final Double result = math.divide(a, b);

    assertTrue(result > 0);

  }

  @Test
  void noNumerosNegativos(){
    final Math math = new Math();
    final Integer a = -3;
    final Integer b = -5;
    final Integer expected = 0;
    final Integer result = math.sum(a, b);

    assertTrue(result > expected);
  }

}
