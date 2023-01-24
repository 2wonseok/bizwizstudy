package bizwiz.study01;

public class CalculatorPlus {

    public int calculate(int i, int j, String type) {
        switch (type) {
            case "plusA" : return i + j;
            case "plusB" : return i + j + j;
            case "plusC" : return i + j + 2;
            case "plusD" : return i + j + 2;
            case "minusA" : return i - j;
            case "minusB" :
                if(i > 0){
                    i = i * 2;
                }
                return i - j - 2;
            case "minusC" : return i - j - 3;
            case "multiply" : return i * j * 4;
            default: return 0;
        }
    }
}
