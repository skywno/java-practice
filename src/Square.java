import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Square {
	public static int[][] squarePatch(int n) {
        int[][] arr = new int[n][n];
        for (int i=0; i<n;i++){
            for (int j=0; j<n; j++){
                arr[i][j] = n;
            }
        }
        return arr;
    }

    public static int[][] squarePatch2(int n) {
        return Stream.generate(() -> n)
                .limit(n)
                .map(size -> Stream.generate(() -> size).mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

    }


}
