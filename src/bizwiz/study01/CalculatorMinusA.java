package bizwiz.study01;

public class CalculatorMinusA implements CalculatorMinusInterface {
    @Override
    public int minus(int i, int j) {
        return i - j;
    }

    @Override
    public String getType() {
        return "minusA";
    }
}
