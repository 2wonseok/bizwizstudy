package bizwiz.study01;

public class CalculatorPlusC implements CalculatorInterface {

    @Override
    public int calculate(int i, int j) {
        return i + j + 2;
    }


    @Override
    public String getType() {
        return "plusC";
    }
}
