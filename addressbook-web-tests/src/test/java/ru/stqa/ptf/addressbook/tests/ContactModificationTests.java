package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

/**
 * Created by Olga_Verkhovtseva on 5/24/2017.
 */
public class ContactModificationTests extends TestBase {

    @Test

    public void contactModificationTests() {

        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().IsThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Koska", "Pug", "HUG ME", "Address 1", "0987655678", "totop@mail.com", "Address 2", "No notes"));
        }
        app.getContactHelper().selectContactModification();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Koska2", "Pug", "HUG ME", "Address 1", "0987655678", "totop@mail.com", "Address 2", "No notes"));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returntoHomePage();
    }
}