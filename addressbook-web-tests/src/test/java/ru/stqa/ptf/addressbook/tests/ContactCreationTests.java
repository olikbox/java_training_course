package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void contactCreationTests() {

        app.getContactHelper().createContact(new ContactData("Koska", "Pug", "HUG ME", "Address 1", "0987655678", "totop@mail.com", "Address 2", "No notes"));
        app.getNavigationHelper().gotoHomePage();
    }

}
