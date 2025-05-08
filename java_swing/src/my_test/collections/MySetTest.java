package my_test.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MySetTest {

    public static void main(String[] args) {

        // 계층 구조 확인 (업캐스팅된 상태)
        Set<Integer> mTestSet = new HashSet<>();

        // 사용방법

        // HashSet : 중복된 요소를 허용하지 않고, 순서가 없는 자료 구조
        HashSet<Integer> numberSet = new HashSet<>();

        // 요소 추가하기
        numberSet.add(1);
        numberSet.add(1); // 중복 값, 추가되지 않음
        numberSet.add(200);
        numberSet.add(33);
        numberSet.add(33); // 중복 값, 추가되지 않음
        System.out.println("numberSet의 크기 : " + numberSet.size());

        // 요소 제거
        numberSet.remove(1); // remove 할 때 없는 요소를 선택하더라도 오류는 발생하지 않음
        System.out.println("numberSet의 크기 : " + numberSet.size());

        // 자료구조는 반복문과 함께 많이 사용이 된다.
        // for (int i = 0; i < 10; i++) { } - 인덱스 for 구문은 사용 불가

        // 향상된 for 구문으로 set 계열의 데이터를 순회 시킬 수 있다.
        for (Integer num : numberSet) {
            System.out.println("num 값 확인 : " + num);
        }

        // Set 계열을 Iterator(요소 반복자) 타입으로 변환해서 순회 시킬 수 있었다. 지금도 가능
        System.out.println("----------------------------------");
        Iterator<Integer> iter = numberSet.iterator(); // 형 변환 처리 Set --> Iterator 형 변환

    }
}
