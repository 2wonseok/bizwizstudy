package bizwiz.study01Refactoring;

public class CalculatorPlusC implements Operator {

    private int i;
    private int j;

    public CalculatorPlusC(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int calculate() {
        return i + j + 2;
    }
}
