package bizwiz.study01;

public class CalculatorFactory {

    public int getCalculator(int i, int j, String type) {
        switch (type) {
            case "plusA" : return new CalculatorPlusA().calculate(i,j);
            case "plusB" : return new CalculatorPlusB().calculate(i,j);
            case "plusC" : return new CalculatorPlusC().calculate(i,j);
            case "plusD" : return new CalculatorPlusD().calculate(i,j);
            case "minusA" : return new CalculatorMinusA().calculate(i,j);
            case "minusB" : return new CalculatorMinusB().calculate(i,j);
            case "minusC" : return new CalculatorMinusC().calculate(i,j);
            case "multiply" : return new CalculatorMultiply().calculate(i,j);
            default: return 0;
        }
    }
}
