package bizwiz.study01;

public interface CalculatorInterface {
    //todo 4번 다형성이란? CalculatorMinus들만 Minus 인터페이스를 상속받아 minus란 이름의 메소드를 만들어보세요.
    // 4-1 minus 인터페이스에 default메소드를 만들어보세요.
    int calculate(int i, int j);
}

//    인터페이스는 기능에 대한 선언만 가능하기 때문에, 실제 코드를 구현한 로직은 포함될 수 없습니다.
//    하지만 자바8에서 이러한 룰을 깨트리는 기능이 나오게 되었는 데 그것이 Default Method(디펄트 메소드)입니다.
//    메소드 선언 시에 default를 명시하게 되면 인터페이스 내부에서도 로직이 포함된 메소드를 선언할 수 있습니다.