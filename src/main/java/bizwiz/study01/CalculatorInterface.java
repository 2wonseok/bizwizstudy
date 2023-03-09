package bizwiz.study01;

public interface CalculatorInterface {
    //todo 4번 다형성이란? CalculatorMinus들만 Minus 인터페이스를 상속받아 minus란 이름의 메소드를 만들어보세요.
    // 4-1 minus 인터페이스에 default메소드를 만들어보세요.
    int calculate(int i, int j);

    CalculatorEnum getCalcType();
}
