package test.unitary;

import net.sourceforge.jwebunit.junit.WebTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Gorka Olalde on 20/3/16.
 */

public class LoginServletWebTest {
    WebTester tester;
    @Before
    public void before() {
        tester = new WebTester();
        tester.setBaseUrl("http://localhost:8080");
    }

    @Test
    public void testCorrectLogin() {
        tester.beginAt("index.jsp");
        tester.setTextField("username", "TestUser");
        tester.setTextField("password", "TestPass");
        tester.submit();
        tester.assertTitleNotEquals("Login Error");
    }

    @Test
    public void testIncorrectLogin() {
        tester.beginAt("index.jsp");
        tester.setTextField("username", "BadUser");
        tester.setTextField("password", "TestPass");
        tester.submit();
        tester.assertTitleEquals("Login Error");
    }

    @Test
    public void testIncorrectPass() {
        tester.beginAt("index.jsp");
        tester.setTextField("username", "TestUser");
        tester.setTextField("password", "BadPassword");
        tester.submit();
        tester.assertTitleEquals("Login Error");
    }

    @Test
    public void testIncorrectBoth() {
        tester.beginAt("index.jsp");
        tester.setTextField("username", "BadUser");
        tester.setTextField("password", "BadPassword");
        tester.submit();
        tester.assertTitleEquals("Login Error");
    }
}
