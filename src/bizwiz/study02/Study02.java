package bizwiz.study02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Study02 {
    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());

        for (int o1 : list) {
            for (int o2 : list) {
                //이 루프의 시간복잡도는 ? O(n^2) 입력 데이터 받은 n만큼 루프를 돌리는데, 그 안에서 루프를 또 n만큼 돌리게 될 때의 표기방법
                System.out.println("1. 몇번 실행 되는가?");

            }
        }

        for (int o : list) {
            if (o > 50) {
                //이 루프의 시간복잡도는 ? O(n)
                System.out.println("2. 몇번 실행 되는가?"+o);
            }
        }

        for (int o : list) {
            if (o > 50) {
                break;
            }
            System.out.println("3. 몇번 실행 되는가?"+ o); // O(log n) 입력 받은 데이터의 크기를 반으로 줄여 가면서 코드를 실행
        }

        list.stream()
                .takeWhile(o -> o <50)
                .forEach(o->{
            System.out.println("4. 몇번 실행 되는가?" + o);
        });

        // list의 특정 item을 조회할때 O(1)이 되게하려면 어떻게 처리해야할것인가?
        // takeWhile 을 사용
    }
}
