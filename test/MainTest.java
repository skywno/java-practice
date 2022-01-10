import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class MainTest {

    @Test
    public void multiplyByOne(){
        assertEquals(2, Main.multiplyByNumber(2,1));

    }
}
