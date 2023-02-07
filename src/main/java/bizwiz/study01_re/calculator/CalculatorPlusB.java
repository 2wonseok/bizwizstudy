package bizwiz.study01_re.calculator;

import bizwiz.study01_re.CalculatorInterface;
import bizwiz.study01_re.CalculatorEnum;

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
