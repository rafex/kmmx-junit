package mx.kmmx.junit5;

public class Math {

    public Integer sum(Integer a, Integer b){
        
        return a+b;
    }

    public Float mult(Float a, Float b){
        return a*b;
    }

    // BigDecimal
    public Float sub(Float a, Float b){
        return a-b;
    }

    public Double divide(Double a, Double b){
        if(b != 0){
            return a/b;
        } else {
            throw new ArithmeticException();
        }
    }
}
