package authTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Gorka Olalde on 16/3/16.
 */
@Suite.SuiteClasses({AuthHashMD5Tests.class
        , AuthManagerTests.class
        , AuthPlainTests.class
        , Base64CoderTests.class})
@RunWith(Suite.class)
public class AuthTestSuite {

}
