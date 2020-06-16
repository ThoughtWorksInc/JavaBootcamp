package bootcamp.process.calculator;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.data.Status;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import java.math.BigDecimal;
import java.util.Optional;

public class CalculatorTest {
    @Test
    public void testAddition(){
        Params params = new Params(new BigDecimal(3), new BigDecimal(5), "+");
        Result result = new Calculator().calculate(params);
        System.out.println(result);
        Result expectedResult = new Result(Status.SUCCESS, null, Optional.ofNullable(new BigDecimal(8)));
        assertEquals(expectedResult.getStatus(), result.getStatus());
        assertEquals(expectedResult.getValue(), result.getValue());
        assertEquals(expectedResult.getStatusMessage(), result.getStatusMessage());
        };

    @Ignore
    @Test
    public void testDivisionByZero(){
        Params params = new Params(new BigDecimal(3), new BigDecimal(0), "/");
        Result result = new Calculator().calculate(params);

//        Result expectedResult = new Result(Status.ARITHMETIC_ERROR, )
        assertEquals(Status.ARITHMETIC_ERROR, result.getStatus());
        assertThat(result.getStatusMessage(), containsString("arithmetic"));
        assertEquals(null, result.getValue());
    }
}
