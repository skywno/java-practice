import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;

public class MainTest {

    @Test
    public void zeroQuery() {
        InputStream stdin = System.in;
        String userInput = "0";
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "";
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

    @Test
    public void oneQuery(){
    InputStream stdin = System.in;
    String queryNumber = "1 0 2 10";
    ByteArrayInputStream bais = new ByteArrayInputStream(queryNumber.getBytes());
    System.setIn(bais);

    String expected = "2 6 14 30 62 126 254 510 1022 2046 ";
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    PrintStream stdout = System.out;
    System.setOut(ps);

    Main.main(null);

    String[] lines = baos.toString().split(System.lineSeparator());
    String actual = lines[lines.length-1];
    assertEquals(expected, actual);

    }
}