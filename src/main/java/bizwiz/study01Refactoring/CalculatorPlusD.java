package bizwiz.study01Refactoring;

public class CalculatorPlusD implements Operator {


    @Override
    public int calculate(int i, int j) {
        return i + j + 2;
    }
}
