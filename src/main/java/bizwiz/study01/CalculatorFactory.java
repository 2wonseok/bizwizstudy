package bizwiz.study01;

import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CalculatorFactory {
    private final Map<CalculatorEnum, CalculatorInterface> calculatorIntanceMap;
    public CalculatorFactory(){
        calculatorIntanceMap = createCalcInstances("bizwiz.study01.calculator");
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
    public CalculatorInterface getCalculator(CalculatorEnum type) {
        return calculatorIntanceMap.get(type);
    }
}
