package bizwiz.study01_re.calculator;

import bizwiz.study01_re.CalculatorEnum;
import bizwiz.study01_re.CalculatorInterface;
import bizwiz.study01_re.CalculatorInterfaceMinus;

public class CalculatorMultiply implements CalculatorInterface {
    @Override
    public int calculate(int i, int j) {
        return i * j * 4;
    }

    @Override
    public CalculatorEnum getCalcType() {
        return CalculatorEnum.MULTIPLY;
    }
}
