package bizwiz.study01;

public class CalculatorPlusA implements CalculatorInterface {

    @Override
    public int calculate(int i, int j) {
        return i + j;
    }
}
