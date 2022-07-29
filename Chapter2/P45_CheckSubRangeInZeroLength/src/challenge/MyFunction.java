package challenge;

import java.util.Objects;

public class MyFunction {
    private static final int UPPER_BOUND = 200;
    private int length;

    public MyFunction(int length) {
        this.length = Objects.checkIndex(length, UPPER_BOUND);
    }

    public int yMinusX(int x, int y){
//        Objects.checkIndex(x, y);
        Objects.checkFromToIndex(x,y,length);
        return y-x;
    }
}
