import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Gorka Olalde on 22/3/16.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( { CalculatorAddTest.class
        , CalculatorSubstractTest.class
        , CalculatorMultiplyTest.class
        , CalculatorDivideTest.class })
public class CalculatorTestSuite {

}
