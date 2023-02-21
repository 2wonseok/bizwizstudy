package bizwiz.study01;

public class CalculatorMinusA implements CalculatorInterface {
    @Override
    public int calculate(int i, int j) {
        return i - j;
    }

    @Override
    public String getType() {
        return "minusA";
    }

}
