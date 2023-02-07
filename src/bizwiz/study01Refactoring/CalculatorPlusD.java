package bizwiz.study01Refactoring;

public class CalculatorPlusD implements Operator {

    private int i;
    private int j;

    public CalculatorPlusD(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int calculate() {
        return i + j + 2;
    }
}
