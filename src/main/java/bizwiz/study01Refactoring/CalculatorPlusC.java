package bizwiz.study01Refactoring;

public class CalculatorPlusC implements Operator {



    @Override
    public int calculate(int i, int j) {
        return i + j + 2;
    }
}
