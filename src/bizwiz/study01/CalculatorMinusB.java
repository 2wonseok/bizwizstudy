package bizwiz.study01;

public class CalculatorMinusB implements CalculatorMinusInterface {
    @Override
    public int minus(int i, int j) {

        if(i > 0){
            i = i * 2;
        }

        return i - j - 2;
    }

    @Override
    public String getType() {
        return "minusB";
    }
}