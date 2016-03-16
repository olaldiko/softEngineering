import authTests.*;
import modelTests.ModelTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Gorka Olalde on 15/3/16.
 */
@Suite.SuiteClasses({AuthTestSuite.class, ModelTestSuite.class})
@RunWith(Suite.class)
public class WebLoginTestSuite {

}
