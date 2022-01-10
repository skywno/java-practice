import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;

public class MainTest {

    @Test
    public void formattingTest() {
        InputStream stdin = System.in;
        String userInput = "java 5";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "java           005";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream stdout = System.out;
        System.setOut(ps);

        Main.main(null);

        System.setIn(stdin);
        System.setOut(stdout);

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        assertEquals(expected, actual);

    }
}