//package bizwiz.study01Refactoring;
//
//import java.util.List;
//import java.util.Scanner;
//import java.util.regex.Pattern;
//
//public class Study01 {
//    public static void main(String[] args) {
//        new Study01().process();
//    }
//
//    @Deprecated
//    public void process() {
//
//
//        try {
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.println("연산 해용...");
//            System.out.println("단 순서는 항상 숫자-클래스-숫자 형태로 입력 하셔야 합니다.");
//
//            String words = scanner.nextLine();
//            List<String> wordList = List.of(words.split(" "));
//
//            int result = 0;
//            String lastWord = null;
//
//            for (String word : wordList) {
//                if (!isInt(word)) {
//                    lastWord = word;
//                    continue;
//                }
//
//                if (lastWord == null) {
//                    result = Integer.parseInt(word);
//                    continue;
//                }
//
//                int j = Integer.parseInt(word);
//                Operator operator = OperatorFactory.getOperator(lastWord);
//                result = operator.calculate(result, j);
//
//            }
//
//            System.out.println("result : " + result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private boolean isInt(String str) {
//        //해당 방법이 좋은지 토론.
//        String pattern = "^[0-9]*$";
//        return Pattern.matches(pattern, str);
//    }
//
//}