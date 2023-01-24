package bizwiz.study01;

import java.util.List;

public class Study01 {
    public static void main(String[] args) {
        new Study01().process();
        new Study01().process("Wonseok");
        new Study01().process2();
    }

    private final CalculatorFactory calculatorFactory = new CalculatorFactory();
    private final CalculatorPlus Calculator = new CalculatorPlus(); // Common
    private final CalculatorPlusA plusA = new CalculatorPlusA(); //x + y
    private final CalculatorPlusB plusB = new CalculatorPlusB(); // x + y + y
    private final CalculatorMinusA minusA = new CalculatorMinusA(); // x - y

    @Deprecated
    public void process() {
        //일반 연산규칙 무시하고 순서대로 class를 호출한다.
        // 추후 system.in 으로 사용자가 입력할 수 있다.
        // 단 순서는 항상 숫자-클래스-숫자 형태로 온다고 가정한다.
        String sortedWords = "10 plusA 3 plusB 2 minusA 4 plusA 2"; // (10 + 3 + (2 + 2) - 4 + 2)
        List<String> wordList = List.of(sortedWords.split(" "));

        int result = 0;
        String lastWord = null;
        for (String word : wordList) {
            if (!isInt(word)) {
                lastWord = word;
            } else if (isInt(word) && lastWord == null) {
                result = Integer.parseInt(word);
            } else if (isInt(word) && lastWord != null) {
                if ("plusA".equals(lastWord)) {
                    result = plusA.calculate(result, Integer.parseInt(word));
                } else if ("plusB".equals(lastWord)) {
                    result = plusB.calculate(result, Integer.parseInt(word));
                } else if ("minusA".equals(lastWord)) {
                    result = minusA.calculate(result, Integer.parseInt(word));
                }
                System.out.println("word : " + word + " result : " + result + " last word" + lastWord );
            } else {
                // ?
            }
        }

        System.out.println("result : " + result);
    }

    /**
     * 저장소에 저장된 임이의 아래와 같은 문자열이 있을때 계산 결과를 받고 싶다.
     * 현재 구현된 class는 모두 입력 가능하다.
     *
     * ex ) "10 plusD 3" or "10 plusD 3 plusA 4 minusD 3" or "10 plus 3 plusD 4 minus 3"
     *
     * Factory Pattern , Stack(Queue)등을 활용할 수 있다.
     */
    public void process(String string) {

        String sortedWords = "10 plusA 3 plusB 2 minusA 4 plusA 2"; // (10 + 3 + (2 + 2) - 4 + 2)
        List<String> wordList = List.of(sortedWords.split(" "));

        int result = 0;
        String lastWord = null;
        for (String word : wordList) {
            if (!isInt(word)) {
                lastWord = word;
            } else if (isInt(word) && !isNotNull(lastWord)) {
                result = Integer.parseInt(word);
            } else if (isInt(word) && isNotNull(lastWord)) {
                result = Calculator.calculate(result, Integer.parseInt(word), lastWord);
                System.out.println("word : " + word + " result : " + result + " last word" + lastWord );
            } else {
                // ?
            }
        }

        System.out.println("result : " + result);
    }

    public void process2() {

        String sortedWords = "10 plusA 3 plusB 2 minusA 4 plusA 2"; // (10 + 3 + (2 + 2) - 4 + 2)
        List<String> wordList = List.of(sortedWords.split(" "));

        int result = 0;
        String lastWord = null;
        for (String word : wordList) {
            if (!isInt(word)) {
                lastWord = word;
            } else if (isInt(word) && !isNotNull(lastWord)) {
                result = Integer.parseInt(word);
            } else if (isInt(word) && isNotNull(lastWord)) {
                result = calculatorFactory.getCalculator(result, Integer.parseInt(word), lastWord);
                System.out.println("word : " + word + " result : " + result + " last word" + lastWord );
            } else {
                // ?
            }
        }

        System.out.println("result : " + result);
    }

    private boolean isInt(String str) {
        //해당 방법이 좋은지 토론.
        // spring framework의 NumberUtils를 활용하면 bool 타입의 메소드를 만들 필요 없이 즉시 반환 가능.
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private boolean isNotNull(String str) {
        // spring framework의 StringUtils를 활용하면 bool 타입의 메소드를 만들 필요 없이 즉시 반환 가능.
        if(!"".equals(str) && null != str) {
            return true;
        } else {
            return false;
        }
    }

}