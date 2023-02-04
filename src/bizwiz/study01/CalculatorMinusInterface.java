package bizwiz.study01;

public interface CalculatorMinusInterface {

    int minus(int i, int j);

    default int comMinus(int i, int j) {
        return this.minus(i, j);
    }

    String getType();
}

