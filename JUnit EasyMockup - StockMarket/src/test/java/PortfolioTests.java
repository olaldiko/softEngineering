import com.sun.org.apache.xpath.internal.operations.Variable;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import stock.Portfolio;
import stock.Stock;
import stock.StockMarket;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

/**
 * Created by Gorka Olalde on 15/3/16.
 */
@RunWith(EasyMockRunner.class)
public class PortfolioTests {

    @TestSubject
    Portfolio portfolio = new Portfolio();

    @Mock
    StockMarket stockMarket = EasyMock.strictMock(StockMarket.class);

    @Before
    public void before() {
        portfolio.setStockMarket(stockMarket);
    }

    @After
    public void after() {

    }

    @Test
    public void nameGettersTest() {
        portfolio.setName("Name");
        assertEquals("Name not correctly set", "Name", portfolio.getName());
    }

    @Test
    public void addStocksTest() {
        List<Stock> stockList;
        Stock stock = new Stock("Stock1", 100);
        portfolio.addStock(stock);
        stockList = portfolio.getStocks();
        assertThat("Returned stock is not the one that was added"
                , stockList.get(0), is(equalTo(stock)));
    }

    @Test
    public void stockMarketGettersTest() {
        StockMarket returnedMarket;
        portfolio.setStockMarket(stockMarket);
        returnedMarket = portfolio.getStockMarket();
        assertThat("Returned market is no the same as the one added"
                , returnedMarket, is(equalTo(stockMarket)));
    }

    @Test
    public void setStockListTest() {
        List<Stock> stockList = new ArrayList<>();
        List<Stock> returnedStocks;
        Stock stock = new Stock("Stock1", 100);
        stockList.add(stock);
        portfolio.setStocks(stockList);
        returnedStocks = portfolio.getStocks();
        assertThat("Returned stocks aren't the inserted ones"
                , returnedStocks.get(0), is(equalTo(stock)));
    }

    @Test
    public void getTotalValueTest() {
        Stock s1, s2;
        Double expectedValue = 20.0;
        Double totalValue;

        s1 = new Stock("Stock1", 1);
        s2 = new Stock("Stock2", 1);
        portfolio.addStock(s1);
        portfolio.addStock(s2);

        resetToStrict(stockMarket);
        expect(stockMarket.getPrice("Stock1")).andReturn(10.0).times(1);
        expect(stockMarket.getPrice("Stock2")).andReturn(10.0).times(1);

        replay(stockMarket);
        totalValue = portfolio.getTotalValue();
        verify(stockMarket);
        assertEquals("Calculated total value is not the expected one"
                , expectedValue, totalValue);
    }

}
