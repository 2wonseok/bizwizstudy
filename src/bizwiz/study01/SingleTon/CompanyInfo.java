package bizwiz.study01.SingleTon;

public class CompanyInfo {
    // 싱글톤(Singleton) 패턴의 정의는 단순하다. 객체의 인스턴스가 오직 1개만 생성되는 패턴을 의미한다
    // 장점
    // 1. new 연산자를 통해서 고정된 메모리 영역을 사용하기 때문에 추후 해당 객체에 접근할 때 메모리 낭비를 방지할 수 있다.
    // 2. 데이터 공유가 쉽다는 것이다. 싱글톤 인스턴스가 전역으로 사용되는 인스턴스이기 때문에 다른 클래스의 인스턴스들이 접근하여 사용할 수 있다.

    // 단점
    // 1. 싱글톤 패턴을 구현하는 코드 자체가 많이 필요하다.
    // 2. 두 번째는 테스트하기 어렵다는 것이다. 싱글톤 인스턴스는 자원을 공유하고 있기 때문에 테스트가 결정적으로 격리된 환경에서 수행되려면 매번 인스턴스의 상태를 초기화시켜주어야 한다.

//    만약 싱글톤 인스턴스가 혼자 너무 많은 일을 하거나, 많은 데이터를 공유시키면 다른 클래스들 간의 결합도가 높아지게 되는데, 이때 개방-폐쇄 원칙이 위배된다.
//    결합도가 높아지게 되면, 유지보수가 힘들고 테스트도 원활하게 진행할 수 없는 문제점이 발생한다.
//    또한, 멀티 스레드 환경에서 동기화 처리를 하지 않았을 때, 인스턴스가 2개가 생성되는 문제도 발생할 수 있다.

    // 개방 패쇠 원칙이란
//    OCP는 소프트웨어 구성 요소(컴포넌트, 클래스, 모듈, 함수)는 확장에 대해서는 개방(OPEN)되어야 하지만 변경에 대해서는 폐쇄(CLOSE)되어야 한다는 의미입니다.
//    즉, 기존의 코드를 변경하지 않으면서 기능을 추가할 수 있도록 설계가 되어야 한다는 의미입니다.

    private static CompanyInfo innstance;

    private String companyName;
    private String companyAddr;


    private CompanyInfo()
    {
    }

    public static CompanyInfo getInstance()
    {
        if (innstance == null)
        {
            synchronized(CompanyInfo.class)
            {
                innstance = new CompanyInfo();
            }
        }

        return innstance;
    }


    // getter, setter
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }
}
