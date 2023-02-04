package bizwiz.study01;


import bizwiz.study01.InterfaceList.CalculatorInterfaceList;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculatorFactory {

    //todo 20230126 3번 이 if문을 없애고 싶을때 어떤방법이 있을까요?
    // 참고로 클래스가 생성되어있어도 됩니다.(싱글턴이어도 괜찮음)

    public static CalculatorInterface getInterface(String type) {
        List<CalculatorInterface> interfaceList = CalculatorInterfaceList.getDefaultInterfaceList();
        Map<String, CalculatorInterface> interfaceMap = interfaceList.stream()
                .collect(Collectors.toMap(CalculatorInterface::getType, cls -> cls));
        return interfaceMap.get(type);
    }

    public static CalculatorMinusInterface getMinusInterface(String type) {
        List<CalculatorMinusInterface> interfaceList = CalculatorInterfaceList.getMinusInterfaceList();
        Map<String, CalculatorMinusInterface> interfaceMap = interfaceList.stream()
                .collect(Collectors.toMap(CalculatorMinusInterface::getType, cls -> cls));
        return interfaceMap.get(type);
    }

    //todo 20230126 5번 싱글톤이란 무엇일까요? static에서 전역변수 사용시 에서는 무슨 일이 발생할까요?
}
