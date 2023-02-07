package bizwiz.study01_re;

import bizwiz.study01_re.CalculatorEnum;
import bizwiz.study01_re.CalculatorInterface;

public interface CalculatorInterfaceMinus extends CalculatorInterface {

    @Override
    default int calculate(int i, int j) {
        return i - j;
    }

    @Override
    default CalculatorEnum getCalcType() {
        return CalculatorEnum.MINUS;
    }

}
