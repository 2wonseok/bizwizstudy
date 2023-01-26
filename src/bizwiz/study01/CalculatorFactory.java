package bizwiz.study01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CalculatorFactory {

    //todo 20230126 3번 이 if문을 없애고 싶을때 어떤방법이 있을까요?
    // 참고로 클래스가 생성되어있어도 됩니다.(싱글턴이어도 괜찮음)
    private static String preFix = "bizwiz.study01.Calculator";

    public CalculatorInterface getInterfaceReflection(String type) {
        String sufFix = type.replaceFirst(type.substring(0,1), type.substring(0,1).toUpperCase());
        String claName = preFix+sufFix;
        try {
            Class cls = Class.forName(claName);
            Constructor constructor = cls.getDeclaredConstructor();
            return (CalculatorInterface) constructor.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CalculatorMinusInterface getInterfaceReflectionMinus(String type) {
        String sufFix = type.replaceFirst(type.substring(0,1), type.substring(0,1).toUpperCase());
        String claName = preFix+sufFix;
        try {
            Class cls = Class.forName(claName);
            Constructor constructor = cls.getDeclaredConstructor();
            return (CalculatorMinusInterface) constructor.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    //todo 20230126 5번 싱글톤이란 무엇일까요? static에서 전역변수 사용시 에서는 무슨 일이 발생할까요?
//    public CalculatorInterface getCalculator(String type) {
//        switch (type) {
//            case "plusA":
//                return new CalculatorPlusA();
//            case "plusB":
//                return new CalculatorPlusB();
//            case "plusC":
//                return new CalculatorPlusC();
//            case "plusD":
//                return new CalculatorPlusD();
//            case "minusA":
//                return new CalculatorMinusA();
//            case "minusB":
//                return new CalculatorMinusB();
//            case "minusC":
//                return new CalculatorMinusC();
//            case "multiply":
//                return new CalculatorMultiply();
//            default:
//                throw new IllegalArgumentException("type not support : " + type);
//        }
//    }
}
