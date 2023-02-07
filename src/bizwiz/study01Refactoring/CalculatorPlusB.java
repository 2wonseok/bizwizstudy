package bizwiz.study01Refactoring;

public class CalculatorPlusB implements Operator {

    private int i;
    private int j;

    public CalculatorPlusB(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int calculate() {
        return i + j + j;
    }
}
