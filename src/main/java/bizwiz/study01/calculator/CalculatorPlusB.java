package bizwiz.study01.calculator;

import bizwiz.study01.CalculatorEnum;
import bizwiz.study01.CalculatorInterface;

public class CalculatorPlusB implements CalculatorInterface {

    @Override
    public int calculate(int i, int j) {
        return i + j + j;
    }

    @Override
    public CalculatorEnum getCalcType() {
        return CalculatorEnum.PLUS_B;
    }
}
