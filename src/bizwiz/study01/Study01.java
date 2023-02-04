package bizwiz.study01;

import java.util.List;

public class Study01 {
    public static void main(String[] args) {
        new Study01().process();
    }

    public void process() {
        //일반 연산규칙 무시하고 순서대로 class를 호출한다.
        // 추후 system.in 으로 사용자가 입력할 수 있다.
        // 단 순서는 항상 숫자-클래스-숫자 형태로 온다고 가정한다.
        String sortedWords = "10 plusA 3 plusB 2 minusA 4 plusA 2"; // (10 + 3 + (2 + 2) - 4 + 2)
        List<String> wordList = List.of(sortedWords.split(" "));

        int result = 0;
        String lastWord = null;
        for (String word : wordList) {
            // todo 20230126 1번 좀 더 가독성 좋도록 리팩토링 해보세요.(해당 조건문들만)
            // 좀 더 코드량을 줄일 수 있는지 찾아보세요. (람다 활용/ 리팩토링 중 extract method도 가능)
            if (isInt(word)) {
                result = isEmpty(lastWord) ? Integer.parseInt(word) : calculator(lastWord, result, Integer.parseInt(word));
            } else {
                lastWord = word;
            }
        }

        System.out.println("result : " + result);
    }

    private int calculator(String lastWord, int result, int result1) {
        if(lastWord.contains("minus")) {
            CalculatorMinusInterface minus = CalculatorFactory.getMinusInterface(lastWord);
            result = minus.comMinus(result, result1);
        } else {
            CalculatorInterface calculator = CalculatorFactory.getInterface(lastWord);
            result = calculator.calculate(result, result1);
        }

        System.out.println("word : " + lastWord + " result : " + result + " last word :" + lastWord );
        return result;
    }

    private boolean isInt(String str) {
        //todo todo 20230126 2번 오늘 나온 내용(number utils등)을 바탕으로 해당 메소드들를 분석 후 가장 좋은 방식으로 리팩토링해보세요.
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    private boolean isEmpty(String str) {
        if(str == null || str == "") {
            return true;
        } else {
            return false;
        }
    }


}