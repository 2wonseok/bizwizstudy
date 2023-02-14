package bizwiz.study01Refactoring;

public class CalculatorMinusA implements Operator {


    @Override
    public int calculate(int i, int j) {
        return i - j;
    }
}
