package bizwiz.study01Refactoring;

public class OperatorFactory {

    public static Operator getOperator(String type) {

        try {

            switch (type) {
                case "plusA" :
                    return new CalculatorPlusA();
                case "plusB" :
                    return new CalculatorPlusB();
                case "plusC" :
                    return new CalculatorPlusC();
                case "plusD" :
                    return new CalculatorPlusD();
                case "minusA" :
                    return new CalculatorMinusA();
                case "minusB" :
                    return new CalculatorMinusB();
                case "minusC" :
                    return new CalculatorMinusC();
                default:
                    throw new ClassNotFoundException("Type Not Found!!! ");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
