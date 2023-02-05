package bizwiz.study01;

import java.util.List;

public class Study01 {
    public static void main(String[] args) {
        new Study01().process();
    }

    private final static CalculatorFactory calculatorFactory = new CalculatorFactory();

    public void process() {
        //일반 연산규칙 무시하고 순서대로 class를 호출한다.
        // 추후 system.in 으로 사용자가 입력할 수 있다.
        // 단 순서는 항상 숫자-클래스-숫자 형태로 온다고 가정한다.
        String sortedWords = "10 plusA 3 plusB 2 minusA 4 plusA 2"; // (10 + 3 + (2 + 2) - 4 + 2)
        List<String> wordList = List.of(sortedWords.split(" "));

        int result = 0;
        String lastWord = null;
        for (String word : wordList) {
            //todo 20230126 1번 좀 더 가독성 좋도록 리팩토링 해보세요.(해당 조건문들만)
            // 참고 study01Refactoring은 이현호대리님 코드입니다.
            // 좀 더 코드량을 줄일 수 있는지 찾아보세요. (람다 활용/ 리팩토링 중 extract method도 가능)

            /* Extract Method 메서드 추출 리팩토링
                - 한 메서드안에 이런저런 세세한 처리가 많다면 그런 처리를 묶어서 나누고 독립된 메서드로 추출하고 추출한 메서드에는 적절한 이름을 붙임.
                - 장황한 코드가 읽기 편해짐.
                - 장단점 : 각 메서드가 짧아지는 장점이 있는 반면 메서드 개수가 늘어남
            */
            if (!isInt(word)) {
                lastWord = word;
            } else if (isInt(word) && lastWord == null) {
                result = Integer.parseInt(word);
            } else if (isInt(word) && lastWord != null) {
                CalculatorInterface calculator = calculatorFactory.getCalculator(lastWord);
                result = calculator.calculate(result, Integer.parseInt(word));
                System.out.println("word : " + word + " result : " + result + " last word" + lastWord );
            } else {
                // ?
            }
        }

        System.out.println("result : " + result);
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


}