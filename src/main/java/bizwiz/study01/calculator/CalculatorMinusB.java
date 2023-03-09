package bizwiz.study01.calculator;

import bizwiz.study01.CalculatorEnum;
import bizwiz.study01.CalculatorInterface;

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
