import java.util.Arrays;
import java.util.stream.IntStream;

public class Program{

	//source: https://edabit.com/challenge/J26bZ6Fv6bWEisDYj
	public static double[] otherSides(int n) {
		double longestSide = (n * 2 * 100) / 100.0;
		double mediumLengthSide = ((int) (n * Math.sqrt(3) * 100)) / 100.0;
		return new double[]{longestSide, mediumLengthSide};

	}
	public static double[] otherSidesRefactored(int n) {
		double [] arr = new double[2];
		arr[0] = n * 2.0;
		arr[1] = ((int) (n * Math.sqrt(3) * 100)) / 100.0;
		return arr;
	}

	//source: https://edabit.com/challenge/A2M6aC7BR2P4Qj2Kr
	public static int findSeat(int n, int[] arr) {
		if (arr.length < 1) return -1;

		double maxCapacity = n / arr.length * 0.5;
		for (int i=0;i<arr.length;i++){
			if (arr[i] < maxCapacity) return i;
		}
		return -1;
	}
	public static int findSeat2(int n, int[] arr) {
		if (arr.length < 1) return -1;
		double maxCapacity = n / arr.length * 0.5;
		return IntStream.range(0, arr.length).filter( i -> arr[i] < maxCapacity).findFirst().orElse(-1);
	}

	//source: https://edabit.com/challenge/H6eTNH6NW36MHqkjb
	public static int pentagonal(int num){
		if (num <=1) {
			return 1;
		}
		return pentagonal(num-1) + (num * 5 - 5);
	}
	public static int pentagonalRefactored(int num){
		return (num == 1) ? 1 : pentagonal(num-1) + 5*(num-1);
	}

	public static String add(String a, String b) {
		try{
			int sum = Integer.parseInt(a) + Integer.parseInt(b);
			return String.valueOf(sum);
		} catch (Exception e){
			return "Invalid Operation";
		}
	}

	public static String addRefactored(String a, String b) {
		try{
			return Integer.parseInt(a) + Integer.parseInt(b)+"";
		} catch (Exception e){
			return "Invalid Operation";
		}
	}

	//source: https://edabit.com/challenge/GJh9FraKutcnHoruX
	public static int missingNum(int[] nums) {
		return 55 - Arrays.stream(nums).sum();
	}
}
