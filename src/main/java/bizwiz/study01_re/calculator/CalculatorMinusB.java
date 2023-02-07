package bizwiz.study01_re.calculator;

import bizwiz.study01_re.CalculatorEnum;
import bizwiz.study01_re.CalculatorInterface;
import bizwiz.study01_re.CalculatorInterfaceMinus;

public class CalculatorMinusB implements CalculatorInterface {
    @Override
    public int calculate(int i, int j) {

        if(i > 0){
            i = i * 2;
        }

        return i - j - 2;
    }

    @Override
    public CalculatorEnum getCalcType() {
        return CalculatorEnum.MINUS_B;
    }
}
