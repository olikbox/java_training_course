package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by Olga_Verkhovtseva on 5/24/2017.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void contactDeletionTests() {

        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().IsThereAContact()) {
            app.getContactHelper().createContact(new ContactData( "Koska", "Pug", "HUG ME", "Address 1", "0987655678", "totop@mail.com"));
        }
        app.getContactHelper().selectContactModification();
        app.getContactHelper().initContactModification();
        app.getContactHelper().submitContactDelete();
        app.getNavigationHelper().gotoHomePage();
        List <ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContacts();
        app.getNavigationHelper().gotoHomePage();
        List <ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}

