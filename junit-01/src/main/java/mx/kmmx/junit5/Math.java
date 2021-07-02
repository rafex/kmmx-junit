package mx.kmmx.junit5;

public class Math {
  
  public Integer sum(final Integer a, final Integer b) {
    return a + b;
  }
  
  public Float mult(final Float a, final Float b) {
    return a * b;
  }
  
  // BigDecimal
  public Float sub(final Float a, final Float b) {
    return a - b;
  }
  
  public Double divide(final Double a, final Double b) {
    if (b != 0) {
      return a / b;
    } else {
      throw new ArithmeticException();
    }
  }
  
  public boolean mod(final int number) {
    return number % 2 != 0;
  }
}
