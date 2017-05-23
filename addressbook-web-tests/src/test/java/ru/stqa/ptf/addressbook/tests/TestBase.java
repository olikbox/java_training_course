package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.ptf.addressbook.appmanger.ApplicationManger;

/**
 * Created by Olga_Verkhovtseva on 5/22/2017.
 */
public class TestBase {

    public ApplicationManger app = new ApplicationManger();

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
