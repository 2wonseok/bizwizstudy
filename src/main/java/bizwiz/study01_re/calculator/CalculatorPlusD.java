package bizwiz.study01_re.calculator;

import bizwiz.study01_re.CalculatorEnum;
import bizwiz.study01_re.CalculatorInterface;

public class CalculatorPlusD implements CalculatorInterface {

    @Override
    public int calculate(int i, int j) {
        return i + j + 2;
    }
    @Override
    public CalculatorEnum getCalcType() {
        return CalculatorEnum.PLUS_D;
    }
}
