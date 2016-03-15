import main.ClassTested;
import main.Collaborator;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gorka Olalde on 15/3/16.
 */
@RunWith(EasyMockRunner.class)
public class ClassTestedRemoveDocTests {

    @TestSubject
    ClassTested testedClass = new ClassTested();

    @Mock
    Collaborator collaborator = mock(Collaborator.class);

    @Before
    public void before() {
        testedClass.setListener(collaborator);
    }

    @Test
    public void testRemoveNullDoc() {
        boolean retVal;
        retVal = testedClass.removeDocument("Document1");
        assertFalse("Expected to be false", retVal);
    }

    @Test
    public void testRemoveNotVotedDoc() {
        boolean retVal;
        testedClass.addDocument("Document1", "Test");
        reset(collaborator);
        expect(collaborator.voteForRemoval("Document1")).andReturn((byte) 0).times(1);
        replay(collaborator);
        retVal = testedClass.removeDocument("Document1");
        verify(collaborator);
        assertFalse("Expected false when deleting the document", retVal);
    }

    @Test
    public void testRemoveVotedDoc() {
        boolean retVal;
        testedClass.addDocument("Document1", "Test");
        reset(collaborator);
        expect(collaborator.voteForRemoval("Document1")).andReturn((byte) 1).times(1);
        collaborator.documentRemoved("Document1");
        replay(collaborator);
        retVal = testedClass.removeDocument("Document1");
        verify(collaborator);
        assertTrue("Expected to be true as document remooved ok", retVal);
    }

    @Test
    public void testRemoveMultipleDocsOk() {
        boolean retVal;
        testedClass.addDocument("Document1", "test");
        testedClass.addDocument("Document2", "test");
        reset(collaborator);
        expect(collaborator.voteForRemovals("Document1", "Document2")).andReturn((byte)1);
        collaborator.documentRemoved("Document1");
        collaborator.documentRemoved("Document2");
        replay(collaborator);
        testedClass.removeDocuments("Document1", "Document2");
        verify(collaborator);
    }
}
