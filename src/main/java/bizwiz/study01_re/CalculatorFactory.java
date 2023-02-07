package bizwiz.study01_re;

import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CalculatorFactory {
    private final Map<CalculatorEnum, CalculatorInterface> calculatorIntanceMap;
    public CalculatorFactory(){
        calculatorIntanceMap = createCalcInstances("bizwiz.study01_re.calculator");
    }

    private Map<CalculatorEnum, CalculatorInterface> createCalcInstances(String packagePath){
        Reflections reflections = new Reflections(packagePath);
        Set<Class<? extends CalculatorInterface>> allClasses =
                reflections.getSubTypesOf(CalculatorInterface.class);

        return allClasses.stream().map(cls->{
            try {
                return cls.getConstructor().newInstance();
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toMap(CalculatorInterface::getCalcType, Function.identity()));
    }

    //todo 20230126 5번 싱글톤이란 무엇일까요? static에서 전역변수 사용시 에서는 무슨 일이 발생할까요?
    //=> 객체의 인스턴스가 오직 1개만 생성되는 패턴, 자원의 이점이 있음, 클래스간 데이터공유 쉬움..
    //=> 단점) 멀티스레딩 환경에서 발생할 수 있는 동시성문제(해결하기 위해 syncronized키워드사용)
    //         테스트 하기 함듬 (매번 인스턴스 초기화해줘야함..)
    public CalculatorInterface getCalculator(CalculatorEnum type) {
        return calculatorIntanceMap.get(type);
    }
}
