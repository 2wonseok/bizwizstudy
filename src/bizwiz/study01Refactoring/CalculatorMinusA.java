package bizwiz.study01Refactoring;

public class CalculatorMinusA implements Operator {

    private int i;
    private int j;

    public CalculatorMinusA(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int calculate() {
        return i - j;
    }
}
