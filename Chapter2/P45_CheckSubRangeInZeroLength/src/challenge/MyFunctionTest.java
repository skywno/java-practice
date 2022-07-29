package challenge;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class MyFunctionTest {

    @Test
    void yMinusX() {
        MyFunction f = new MyFunction(50);

        int r = f.yMinusX(10, 30);
        System.out.println("r=" + r);
    }
}