package bizwiz.study01;

public class CalculatorFactory {

    //todo 20230126 3번 이 if문을 없애고 싶을때 어떤방법이 있을까요?
    // 참고로 클래스가 생성되어있어도 됩니다.(싱글턴이어도 괜찮음)

    //todo 20230126 5번 싱글톤이란 무엇일까요? static에서 전역변수 사용시 에서는 무슨 일이 발생할까요?
    public CalculatorInterface getCalculator(String type) {
        switch (type) {
            case "plusA":
                return new CalculatorPlusA();
            case "plusB":
                return new CalculatorPlusB();
            case "plusC":
                return new CalculatorPlusC();
            case "plusD":
                return new CalculatorPlusD();
            case "minusA":
                return new CalculatorMinusA();
            case "minusB":
                return new CalculatorMinusB();
            case "minusC":
                return new CalculatorMinusC();
            case "multiply":
                return new CalculatorMultiply();
            default:
                throw new IllegalArgumentException("type not support : " + type);
        }
    }
}
