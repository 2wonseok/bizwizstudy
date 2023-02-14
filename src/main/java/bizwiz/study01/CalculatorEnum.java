package bizwiz.study01;

import java.util.stream.Stream;

public enum CalculatorEnum {
    MINUS("minus"),
    MINUS_A("minusA"),
    MINUS_B("minusB"),
    MINUS_C("minusC"),
    MULTIPLY("multiply"),
    PLUS_A("plusA"),
    PLUS_B("plusB"),
    PLUS_C("plusC"),
    PLUS_D("plusD");
    private String classText;

<<<<<<< HEAD
    CalculatorEnum(String classText){this.classText = classText;}
=======
    CalculatorEnum(String classText){
        this.classText = classText;
    }
>>>>>>> master

    public String getClassText(){
        return this.classText;
    }

    public static CalculatorEnum findBy(String text){
        return Stream.of(CalculatorEnum.values())
                .filter(o->o.getClassText().equals(text))
                .findAny()
                .orElseThrow();
    }
}
