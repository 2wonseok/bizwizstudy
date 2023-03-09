package bizwiz.study01Refactoring;

public class CalculatorMinusB implements Operator {



    @Override
    public int calculate(int i, int j) {

        if(i > 0){
            i = i * 2;
        }

        return i - j - 2;
    }
}
