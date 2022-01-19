import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProgramTest {

    @Test
    public void testArrayOfMultiples() {
        int[] ans = Program.arrayOfMultiples(7,5);
        Assert.assertEquals(ans, new int[]{7,14,21,28,35});
        int[] ans2 = Program.arrayOfMultiples(12, 10);
        Assert.assertEquals(ans2, new int[]{12, 24, 36, 48, 60, 72, 84, 96, 108, 120});
    }
}