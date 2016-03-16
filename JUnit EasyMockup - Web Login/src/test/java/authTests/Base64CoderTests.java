package authTests;

import auth.Base64Coder;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gorka Olalde on 15/3/16.
 */

public class Base64CoderTests {


    @Test
    public void encodeStringTest() {
        String inputString = "Test";
        String expectedString = "VGVzdA==";
        String result;
        result = Base64Coder.encodeString(inputString);
        assertEquals("Unexpected encoded string", expectedString, result);
    }

    @Test
    public void decodeStringTest() {
        String inputString = "VGVzdA==";
        String expectedString = "Test";
        String result;
        result = Base64Coder.decodeString(inputString);
        assertEquals("Unexpected decoded string", expectedString, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decodeIncorrectSizeStringTest() {
        String inputString = "aa";
        Base64Coder.decode(inputString);

    }

    @Test(expected = IllegalArgumentException.class)
    public void decodeIllegalStringTest1() {
        String inputString = "\u0129\u0128\u0150\u0180";
        Base64Coder.decode(inputString);
    }

    @Test(expected =  IllegalArgumentException.class)
    public void decodeIllegalStringTest2() {
        String inputString = "\u0000\u0000\u0000\u0000";
        Base64Coder.decode(inputString);
    }
}
