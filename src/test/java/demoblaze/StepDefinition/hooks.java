package demoblaze.StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

import static demoblaze.Helper.utility.quitDriver;
import static demoblaze.Helper.utility.startDriver;

public class hooks {

    @BeforeAll
    public static void setUp() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("After All");
    }

    @Before
    public void beforeTest() {
        System.out.println("Before Test");

        startDriver();
    }

    @After
    public void afterTest() throws InterruptedException {
        System.out.println("After Test");
        quitDriver();
    }
}
