package bizwiz.study01;

public class CalculatorFactory {

    //todo 20230126 3번 이 if문을 없애고 싶을때 어떤방법이 있을까요?
    // 참고로 클래스가 생성되어있어도 됩니다.(싱글턴이어도 괜찮음)

    //todo 20230126 5번 싱글톤이란 무엇일까요? static에서 전역변수 사용시 에서는 무슨 일이 발생할까요?
        /*
    싱글톤 패턴
    장점
    - 객체의 인스턴스가 오직 1개만 생성되는 패턴
    - 생성자가 여러번 호출되도, 실제로 생성되는 객체는 하나이며 최초로 생성된 이후에 호출된 생성자는 이미 생성한 객체를 반환시키도록 만드는 것
    - 싱글톤으로 구현한 인스턴스는 '전역'이므로, 다른 클래스의 인스턴스들이 데이터를 공유하는 것이 가능

    단점
    - 인스턴스가 혼자 너무 많은 일을 하거나, 많은 데이터를 공유시키면 다른 클래스들 간의 결합도가 높아지게 되는데, 이때 개방-폐쇄 원칙이 위배
    - 결합도가 높아지게 되면, 유지보수가 힘들고 테스트도 원활하게 진행할 수 없는 문제점
    - 멀티 스레드 환경에서 동기화 처리를 하지 않았을 때, 인스턴스가 2개가 생성되는 문제


   @ Static : 정적 변수
    - Java에서 Static 키워드를 사용한다는 것은 메모리에 한번 할당되어 프로그램이 종료될 때 해제되는 것을 의미
    - 다른 멤버 변수처럼 클래스 내부에 선언
    - 프로그램이 실행되어 메모리에 올라갔을 때 딱 한번 메모리 공간이 할당됨 그리고 그 값은 모든 인스턴스가 공유
    - static 변수는 인스턴스 생성과는 별개이므로 인스턴스보다 먼저 생성
    - 인스턴스가 아닌 클래스 이름으로도 참조하여 사용
   @ Static에 전역변수를 사용할 경우
    변수를 문서 페이지에서만 지역적으로 작동할 수 있게 쓰겠다는 의미
    - extem : 외부변수를 가져다 씀 / 어딘가에 변수가 선언되어있의 가져다 쓰는 의미로 전역변수 Static을 사용할 수 있게 해줌

    */
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
