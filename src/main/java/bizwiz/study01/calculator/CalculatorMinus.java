package bizwiz.study01.calculator;

import bizwiz.study01.CalculatorEnum;
import bizwiz.study01.CalculatorInterface;

public class CalculatorMinus implements CalculatorInterface {
    @Override
    public int calculate(int i, int j) {
        return i - j;
    }

    @Override
    public CalculatorEnum getCalcType() {
        return CalculatorEnum.MINUS;
    }

}
