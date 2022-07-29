package challenge;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        int r1 = Function.oneMinusY(5);
        System.out.println("r1 = " + r1);

        Function f = new Function(4);
        int r2 = f.xMinusY(3);
        System.out.println("r2 = " + r2);
    }

}

class Function {
    private static final int X_UPPER_BOUND = 11;
    private static final int Y_UPPER_BOUND = 16;

    private final int x;

    public Function(int x) {
        this.x = Objects.checkIndex(x, X_UPPER_BOUND);
    }

    public static int oneMinusY(int y) {
        Objects.checkIndex(y, Y_UPPER_BOUND);
        return 1 - y;
    }


    public int xMinusY(int y) {
//        Objects.checkIndex(y, x);
        return x-y;
    }
}