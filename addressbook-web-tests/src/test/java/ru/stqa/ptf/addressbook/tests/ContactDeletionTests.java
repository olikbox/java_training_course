package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Olga_Verkhovtseva on 5/24/2017.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void contactDeletionTests() {

        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContactModification();
        app.getContactHelper().initContactModification();
        app.getContactHelper().submitContactDelete();
        app.getNavigationHelper().gotoHomePage();
    }
}
