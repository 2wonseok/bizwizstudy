package groovy.bizwiz.study04

import bizwiz.study04.Study04
import bizwiz.study04.Study04Sub
import spock.lang.Specification

class Study04Test extends Specification {

    private Study04 sut;
    private Study04Sub study04Sub;

    def setup() {
        study04Sub = Mock(Study04Sub) //Mock up용. 내부 메서드 mockup이 가능하다.
        //study04Sub = new Study04Sub() - 순수 로직 함수, injection없이 인스턴스 생성만으로 동작하는 함수일때
        sut = new Study04(study04Sub: study04Sub) //생성자가 존재할때는 생성자로 넣어도 되나 미존재시 private 전역을 좌측처럼 명칭을 통해 넣을 수 있다.
    }

    def "test for mockup calculate2 "() {
        given:
        int parameter = 1;
        when:
        /**
         * calculate 로직
         * return i + study04Sub.calculate2(i) + calculatePrivate();
         * study04Sub.calculate2(i)에 따라 값이 변하나 study04Sub는 외부에서 넣어주는(spring의 autowired된) 클래스
         * 그러므로 mockup을 통해 응답값을 예측하여 현재 메소드만 테스트를 한다.
         */
        int result = sut.calculate(parameter);
        then:
        study04Sub.calculate2(_) >> 5
        result == 9
    }

    def "test for mockup calculate2 by implement "() {
        given:
        int parameter = 1;
        when:
        int result = sut.calculate(parameter);
        then:
        //아래처럼 param값을 활용해 직접 계산할 수 있다.
        study04Sub.calculate2(_) >> { args ->
            return args[0] + 1
        }
        result == 6
    }

    def "test for change extraCount gloval variable"() {
        given:
        int parameter = 1;
        study04Sub.calculate2(_) >> 5;
        sut.extraCount = 1; // 원래는 전역변수이고 private이므로 변경이 안되서 좌측처럼 waring나옴. 그러나 변경 가능.
        when:
        int result = sut.calculate(parameter);
        then:
        result == 7
    }

    def "test for call calculate2 by param 1"() {
        when:
        sut.calculateIf(0);
        then:
        // 1번 호출 - https://sabarada.tistory.com/109
        1 * study04Sub.calculate2(_)
    }

    def "test for call calculate2 by param 2"() {
        when:
        sut.calculateIf(1);
        then:
        // 0번 호출
        0 * study04Sub.calculate2(_)
    }
}