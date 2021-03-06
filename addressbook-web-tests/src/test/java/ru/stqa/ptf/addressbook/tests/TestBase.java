package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.ptf.addressbook.appmanger.ApplicationManger;

/**
 * Created by Olga_Verkhovtseva on 5/22/2017.
 */
public class TestBase {

    public static ApplicationManger app = new ApplicationManger ( BrowserType.CHROME );

    @BeforeSuite

    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite

    public void tearDown() {
        app.stop();
    }

}
