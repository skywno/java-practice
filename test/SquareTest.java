import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class SquareTest {

    @Test
    public void testSquarePatchWithZero() {
        Assert.assertEquals(Square.squarePatch(0), new int[][]{});
    }
    @Test
    public void testSquarePatchWithOne() {
        int[][] ret = Square.squarePatch(1);
        boolean result = Arrays.deepEquals(ret, new int[][]{new int[]{1}});
        Assert.assertEquals(result, true);
    }
}