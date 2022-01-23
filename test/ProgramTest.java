import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class ProgramTest {

    @Test
    public void testOtherSides() {
        double[] ret = Program.otherSidesRefactored(1);
        Arrays.stream(ret).forEach(n -> System.out.println(n));
        boolean result = Arrays.equals(ret, new double[]{2.0, 1.73});
        Assert.assertTrue(result);
    }
    @Test
    public void testOtherSidesTwo() {
        double[] ret = Program.otherSidesRefactored(2);
        Arrays.stream(ret).forEach((double n) -> System.out.println(n));
        boolean result = Arrays.equals(ret, new double[]{4.0, 3.46});
        Assert.assertEquals(result, true);
    }

    @Test
    public void testFindSeatWithAvailableSeat() {
        Assert.assertEquals(Program.findSeat2(20, new int[]{3, 5, 4, 2}), 3);
    }

    @Test
    public void testFindSeatWithNotAvailableSeat() {
        Assert.assertEquals(Program.findSeat2(200, new int[]{35, 23, 40, 21, 38}), -1);
    }

    @Test
    public void testFindSeatWithNotAvailableSeatTwo() {
        Assert.assertEquals(Program.findSeat2(200, new int[]{}), -1);
    }

    @Test
    public void testPentogonalWithOne(){
        Assert.assertEquals(Program.pentagonal(1), 1);
    }

    @Test
    public void testPentogonalWithTwo(){
        Assert.assertEquals(Program.pentagonal(2), 6);
    }

    @Test
    public void testPentogonalWithThree(){
        Assert.assertEquals(Program.pentagonal(3), 16);
    }
    @Test
    public void testPentogonalRefactoredWithOne(){
        Assert.assertEquals(Program.pentagonalRefactored(1), 1);
    }

    @Test
    public void testPentogonalRefactoredWithTwo(){
        Assert.assertEquals(Program.pentagonalRefactored(2), 6);
    }

    @Test
    public void testPentogonalRefactoredWithThree(){
        Assert.assertEquals(Program.pentagonalRefactored(3), 16);
    }

    @Test
    public void testAdd(){
        Assert.assertEquals(Program.add("111","111"), "222");
    }
    @Test
    public void testAddwithInvalidInput(){
        Assert.assertEquals(Program.add("","20"), "Invalid Operation");
    }

    @Test
    public void testMissingNumOne(){
        Assert.assertEquals(Program.missingNum(new int[]{10, 5, 1, 2, 4, 6, 8, 3, 9}) ,7);
    }
}