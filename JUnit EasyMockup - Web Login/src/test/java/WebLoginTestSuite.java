import authTests.AuthHashMD5Tests;
import authTests.AuthManagerTests;
import authTests.AuthPlainTests;
import authTests.Base64CoderTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Gorka Olalde on 15/3/16.
 */
@Suite.SuiteClasses({AuthHashMD5Tests.class
        , AuthManagerTests.class
        , Base64CoderTests.class
        , AuthPlainTests.class})
@RunWith(Suite.class)
public class WebLoginTestSuite {

}
