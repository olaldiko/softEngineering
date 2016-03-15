import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import stock.Portfolio;
import stock.StockMarket;

import static org.easymock.EasyMock.strictMock;

/**
 * Created by Gorka Olalde on 15/3/16.
 */

@Suite.SuiteClasses({PortfolioTests.class, StockTests.class})
@RunWith(Suite.class)
public class PortfolioTestSuite {
}
