package bizwiz.study01Refactoring;

public class CalculatorMinusB implements Operator {

    private int i;
    private int j;

    public CalculatorMinusB(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int calculate() {

        if(i > 0){
            i = i * 2;
        }

        return i - j - 2;
    }
}
