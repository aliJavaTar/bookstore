import junit.framework.TestCase;
import org.junit.Test;

public class CalculatorTest extends TestCase {

    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        int a = 3;
        int b = 7;
        int result = calculator.sum(a,b);
        int except=10;
        assertEquals(except,result);
    }
}