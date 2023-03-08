package groovy.study02

import org.apache.commons.lang3.math.NumberUtils
import spock.lang.Specification

class NumberUtilsTest extends Specification {

    def "[isCreatable] when try convert the String `1L` should be return true"(){
        given:
        String str = "1L";
        when:
        boolean result = NumberUtils.isCreatable(str);
        then:
        result
    }

    def "[isParsable] when try convert the String `1L` should be return false"(){
        when:
        def result = NumberUtils.isParsable("1L")
        then:
        !result
    }

    def "[isParsable]when put number should be return result"() {
        expect:
        RESULT == NumberUtils.isParsable(NUMBER)
        where:
        RESULT | NUMBER
        true   | "1.1"
        true   | "1"
        true   | "2"
        false  | "2l"
        false  | "1 1"
        false  | "a"
        false  | ""
        false  | " "

    }
}