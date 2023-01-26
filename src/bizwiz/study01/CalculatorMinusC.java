package bizwiz.study01;

public class CalculatorMinusC implements CalculatorMinusInterface {
    @Override
    public int minus(int i, int j) {
        return i - j - 3;
    }
}
