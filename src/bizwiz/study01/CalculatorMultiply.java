package bizwiz.study01;

public class CalculatorMultiply implements CalculatorInterface {
    @Override
    public int calculate(int i, int j) {
        return i * j * 4;
    }


    @Override
    public String getType() {
        return "multiply";
    }
}
