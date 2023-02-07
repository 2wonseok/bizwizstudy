package bizwiz.study01Refactoring;

public class CalculatorMinusC implements Operator {

    private int i;
    private int j;

    public CalculatorMinusC(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int calculate() {
        return i - j - 3;
    }
}
