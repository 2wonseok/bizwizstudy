package bizwiz.study03;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Study03 {
    public static void main(String[] args) {
        new Study03().test01();
    }

    //todo test01, test01_2 , test01_modify, test02 돌려보시고 왜 에러가 나는지/안나는지
    // 어떻게 하면 잠재적 위협을 벗어날수 있는지 고민해보시고 발표해주세요
    public void test01(){
        List<Integer> list = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
//        for (int o : list) {
//            System.out.println(o);
//            if (o > 60) {
//                list.remove(o);
//            }
//        }
        // re: 보통 리스트나 Map 등, Iterable 객체를 순회하면서 요소를 삭제하거나 변경을 할 때 발생
        // 엘리먼트의 인덱스가 실시간으로 변하기 때문에 발생하는 에러. Length가 변경되면서 해당 인덱스의 값이 null 이 되기 때문에 발생한다.

        // 해결 방법

        // Java 8에서 removeIf() 메소드가 도입되었고, 어떤 요소를 삭제할 것인지에 대한 정의가 구현된 Lambda를 인자로 전달하면 해당하는 요소들이 리스트에서 삭제된다.
//        list.removeIf(o -> o > 60);

        //Iterator는 순회 중에 요소를 삭제해도 ConcurrentModificationException가 발생하지 않도록 설계되어있음.
//        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
//            Integer o = iterator.next();
//            if (o > 60) {
//                iterator.remove();
//            }
//        }

        // for loop로 순회할 때 마지막 Index부터 0번 Index 방향으로 순회하면, 요소를 삭제해도 아직 순회하지 않은 요소들의 Index는 변하지 않기 때문에 문제가 되지 않는다.
        for (int i = list.size() - 1; i >= 0; i--) {
            Integer item = list.get(i);
            if (list.get(i) > 60) {
                list.remove(item);
            }
        }
        System.out.println("list size : "+list.size());
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
