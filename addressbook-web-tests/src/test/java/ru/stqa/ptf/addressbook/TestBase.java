package ru.stqa.ptf.addressbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Olga_Verkhovtseva on 5/22/2017.
 */
public class TestBase {

    protected final ApplicationManger app = new ApplicationManger();

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
