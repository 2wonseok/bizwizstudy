package bizwiz.study01_re.calculator;

import bizwiz.study01_re.CalculatorEnum;
import bizwiz.study01_re.CalculatorInterface;
import bizwiz.study01_re.CalculatorInterfaceMinus;

public class CalculatorMinusA implements CalculatorInterface {
    @Override
    public int calculate(int i, int j) {
        return i - j;
    }

    @Override
    public CalculatorEnum getCalcType() {
        return CalculatorEnum.MINUS_A;
    }
}
