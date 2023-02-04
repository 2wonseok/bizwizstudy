package bizwiz.study01.InterfaceList;

import bizwiz.study01.*;

import java.util.ArrayList;
import java.util.List;

public class CalculatorInterfaceList {

    public static List<CalculatorInterface> getDefaultInterfaceList() {
        List<CalculatorInterface> interfaceList = new ArrayList<>();
        interfaceList.add(new CalculatorPlusA());
        interfaceList.add(new CalculatorPlusB());
        interfaceList.add(new CalculatorPlusC());
        interfaceList.add(new CalculatorPlusD());
        interfaceList.add(new CalculatorMultiply());

        return interfaceList;
    }

    public static List<CalculatorMinusInterface> getMinusInterfaceList() {
        List<CalculatorMinusInterface> interfaceList = new ArrayList<>();
        interfaceList.add(new CalculatorMinusA());
        interfaceList.add(new CalculatorMinusB());
        interfaceList.add(new CalculatorMinusC());

        return interfaceList;
    }
}
