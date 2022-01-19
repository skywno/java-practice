//source: https://edabit.com/challenge/Rs23pTNpM6k5M2ThH
//Date: 2022.01.19

public class Challenge {
    public static int solution(int a, int b, int c) {
        int discriminant = b*b - 4*a*c;
        if (discriminant > 0) return 2;
        else if (discriminant == 0) return 1;
        else return 0;
    }

    public static int solution2(int a, int b, int c) {
        return Integer.signum(b*b-4*a*c) + 1;
    }

    public static int solution3(int a, int b, int c) {
        int d = (int) Math.pow(b,2)-4*a*c;
        return (d == 0) ? 1 : (d > 0) ? 2 : 0;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */


    }
}