package bizwiz.study01_re.calculator;

import bizwiz.study01_re.CalculatorEnum;
import bizwiz.study01_re.CalculatorInterface;
import bizwiz.study01_re.CalculatorInterfaceMinus;

public class CalculatorMinusC implements CalculatorInterface {
    @Override
    public int calculate(int i, int j) {
        return i - j - 3;
    }

    @Override
    public CalculatorEnum getCalcType() {
        return CalculatorEnum.MINUS_C;
    }
}
