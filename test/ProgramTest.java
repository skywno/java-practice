import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProgramTest {

    @Test
    public void testMean() {
        Assert.assertEquals(Program.mean2(new int[]{1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3}), 2.55);
    }

    @Test
    public void testString() {
        String result = Program.flipEndChars("Cat, dog, and mouse.");
        boolean comp = result.equals(".at, dog, and mouseC");
        Assert.assertTrue(comp);
    }

}