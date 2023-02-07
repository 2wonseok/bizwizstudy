package bizwiz.study03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Study03 {
    public static void main(String[] args) {
        new Study03().test02();
    }

    //todo test01, test01_2 , test01_modify, test02 돌려보시고 왜 에러가 나는지/안나는지
    // 어떻게 하면 잠재적 위협을 벗어날수 있는지 고민해보시고 발표해주세요
    public void test01(){
        List<Integer> list = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
        for (int o : list) {
            if (o > 60) {
                list.remove(o);
            }
        }

    }

    public void test01_2(){
        List<Integer> list = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
        Set<Integer> list2 = new HashSet<>(list);
        for (int i = 0; i < list.size(); i++) {
            if (i > 60) {
                list2.remove(i);
            }
        }

        System.out.println("list size : "+list.size() + " / list2 size:" + list2.size());
    }

    public void test01_modify(){
        List<Integer> list = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
        List<Integer> list2 = list.stream().filter(o->o>60).collect(Collectors.toList());
        System.out.println("list size : "+list.size() + " / list2 size:" + list2.size());
    }

    public void test02(){
        List<String> listStr = IntStream.rangeClosed(1, 100).mapToObj(String::valueOf).collect(Collectors.toList());

        List<String> list2 = new ArrayList<>(listStr);
        for (String o : listStr) {
            if (Integer.parseInt(o) > 60) {
                list2.remove(o);
            }
        }

        System.out.println("list size : "+listStr.size() + " / list2 size:" + list2.size());
    }


}
