import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import stock.Stock;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gorka Olalde on 15/3/16.
 */
public class StockTests {

    @TestSubject
    Stock stock = new Stock("TestStock", 1);

    @Test
    public void nameGettersTest() {
        String expectedName = "TestName";
        String name;
        stock.setName(expectedName);
        name = stock.getName();
        assertEquals("Returned name is not the set one", expectedName, name);
    }

    @Test
    public void quantityGettersTest() {
        int expectedQuantity = 10;
        int quantity;
        stock.setQuantity(expectedQuantity);
        quantity = stock.getQuantity();
        assertEquals("Returned quantity is not the set one", expectedQuantity, quantity);
    }

    @Test
    public void constructorTest() {
        String expectedName = "TestStock";
        int expectedQuantity = 1;
        assertEquals("Returned name is not correct", expectedName, stock.getName());
        assertEquals("Returned quantity is not correct", expectedQuantity, stock.getQuantity());
    }
}
