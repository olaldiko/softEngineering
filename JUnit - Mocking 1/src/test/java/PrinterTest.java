import edu.mondragon.eps.document.Document;
import edu.mondragon.eps.document.Printer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;

/**
 * Created by gorkaolalde on 14/3/16.
 */
public class PrinterTest {
    Printer printer;
    Document doc;

    @Before
    public void setUp() {
        printer = mock(Printer.class);
        doc = new Document(printer);

    }
    
    @After
    public void destroy() {

    }

    @Test
    public void testPrint() {
        printer.print("Kaixo");
        replay(printer);
        doc.setContent("Kaixo");
        doc.print();
        verify(printer);
    }
}
