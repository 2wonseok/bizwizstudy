package bizwiz.study04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Study04 {
    private Study04Sub study04Sub;

    private int extraCount = 3;

    public int calculate(int i) {
        return i + study04Sub.calculate2(i) + calculatePrivate();
    }

    public int calculatePrivate(){
        return extraCount;
    }

    public int calculateIf(int i) {
        if(i == 0){
            return study04Sub.calculate2(i);
        }
        return i;
    }

}