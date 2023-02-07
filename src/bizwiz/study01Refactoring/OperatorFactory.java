package bizwiz.study01Refactoring;

import java.lang.reflect.Constructor;

public class OperatorFactory {

    public static Operator getOperator(String type, int i, int j) {

        try {

            String className = "bizwiz.study01Refactoring.Calculator";

            // StringUtils.capitalize()
            className = className + type.substring(0, 1).toUpperCase() + type.substring(1);

            Class bizClass = Class.forName(className);

            Class[] constructorParamClass   = new Class[] {int.class, int.class};
            Object[] constructorParamObject = new Object[] {i, j};
            Constructor constructor = bizClass.getConstructor(constructorParamClass);
            Operator operator = (Operator) constructor.newInstance(constructorParamObject);

            return operator;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
