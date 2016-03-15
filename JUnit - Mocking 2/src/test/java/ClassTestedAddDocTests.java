import main.ClassTested;
import main.Collaborator;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.*;

/**
 * Created by Gorka Olalde on 15/3/16.
 */

@RunWith(EasyMockRunner.class)
public class ClassTestedAddDocTests {

    @TestSubject
    ClassTested testedClass = new ClassTested();

    @Mock
    Collaborator collaborator = strictMock(Collaborator.class);

    @Before
    public void before() {
        testedClass.setListener(collaborator);
    }

    @Test
    public void testAddNotify() {
        resetToStrict(collaborator);
        collaborator.documentAdded("Document1");
        collaborator.documentChanged("Document1");

        replay(collaborator);
        testedClass.addDocument("Document1", "Test");
        testedClass.addDocument("Document1", "Test");
        verify(collaborator);
    }

    @Test
    public void testModifyNotify() {
        resetToStrict();
        collaborator.documentAdded("Document1");
        collaborator.documentChanged("Document1");

        replay(collaborator);
        testedClass.addDocument("Document1", "Test");
        testedClass.addDocument("Document1", "Test2");
        verify(collaborator);
    }
}
