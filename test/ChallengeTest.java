import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static org.testng.Assert.*;

public class ChallengeTest {

    @Test
    public void testTwoSolutions() {
        Assert.assertEquals(Challenge.solution3(1,0,-1), 2);
    }
    @Test
    public void testOneSolution() {
        Assert.assertEquals(Challenge.solution3(1,0,0), 1);
    }

}