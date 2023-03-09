package bizwiz.study01Refactoring;

public class CalculatorPlusA implements Operator {

    public CalculatorPlusA() {

    }


    @Override
    public int calculate(int i, int j) {
        return i + j;
    }
}
