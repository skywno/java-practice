import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProgramTest {

    @Test
    public void TestConversionStringToHex(){
        String str = Program.toHex2("hello world");
        boolean comp = str.equals("68 65 6c 6c 6f 20 77 6f 72 6c 64");
        Assert.assertTrue(comp);
        Assert.assertEquals(Program.toHex2("hello world"), "68 65 6c 6c 6f 20 77 6f 72 6c 64");
    }

    @Test
    public void TestGrade1(){
        Assert.assertEquals(Program.gradePercentage("85%", "85%"), "You PASSED the Exam");
    }

    @Test
    public void TestGrade2(){
        Assert.assertEquals(Program.gradePercentage("99%", "85%"), "You PASSED the Exam");
    }

    @Test
    public void TestGrade3(){
        Assert.assertEquals(Program.gradePercentage("65%", "85%"), "You FAILED the Exam");
    }
}