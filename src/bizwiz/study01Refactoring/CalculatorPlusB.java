package bizwiz.study01Refactoring;

public class CalculatorPlusB implements Operator {



    @Override
    public int calculate(int i, int j) {

        //50 줄
        return i + j + j;
    }
}
