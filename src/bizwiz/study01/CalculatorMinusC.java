package bizwiz.study01;

public class CalculatorMinusC implements CalculatorInterface {
    @Override
    public int calculate(int i, int j) {
        return i - j - 3;
    }

    @Override
    public String getType() {
        return "minusC";
    }
}
