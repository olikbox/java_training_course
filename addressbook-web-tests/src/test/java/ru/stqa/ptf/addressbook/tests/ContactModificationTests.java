package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Olga_Verkhovtseva on 5/24/2017.
 */
public class ContactModificationTests extends TestBase {

    @Test

    public void contactModificationTests() {
        app.getNavigationHelper ( ).gotoHomePage ( );
        if (!app.getContactHelper().IsThereAContact()) {
            app.getContactHelper().createContact(new ContactData( "Koska", "Pug", "HUG ME", "Address 1", "0987655678", "totop@mail.com"));
        }
        List <ContactData> before = app.getContactHelper ( ).getContactList ( );
        ContactData contact = new ContactData ( before.get ( before.size ( ) - 1 ).getId ( ), "Koska2", "Pug", "HUG ME", "Address 1", "0987655678", "totop@mail.com" );
        app.getContactHelper ( ).selectContactModification ( );
        app.getContactHelper().initContactModification();
        app.getContactHelper ( ).editContactForm ( contact );
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returntoHomePage();
        List <ContactData> after = app.getContactHelper ( ).getContactList ( );
        Assert.assertEquals ( after.size ( ), before.size ( ) );


        before.remove(before.size()-1);
        before.add(contact);
        Comparator <? super ContactData> byId  = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals (before,after);
    }
}