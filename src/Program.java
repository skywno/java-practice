import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Program {
    public static int[] arrayOfMultiples(int num, int length) {
        int[] arr = new int[length];
        for (int i=0; i < length; i++){
            arr[i] = num * (i+1);
        }
        return arr;
    }

    public static int[] arrayOfMultiples2(int num, int length) {
        //람다식과 자주 사용되는 함수형 인터페이스 BiFucntion을 이용해서 풀기
        BiFunction<Integer, Integer, int[]> arrayOfMultiples = (Integer n, Integer l) -> {
            int[] arr = new int[l];
            for (int i=0; i < l; i++) {
                arr[i] = n * (i + 1);
            }
            return arr;
        };
        return arrayOfMultiples.apply(num, length);

	}
    public static int[] arrayOfMultiples3(int num, int length) {
        //메서드 참조를 이용해서 풀기
        BiFunction<Integer, Integer, int[]> arrayOfMultiples = Program::arrayOfMultiples2;
        return arrayOfMultiples.apply(num, length);
	}

    public static int[] arrayOfMultiples4(int num, int length) {
        return IntStream.rangeClosed(1, length)
                .map( i -> num * i)
                .toArray();
    }
}
