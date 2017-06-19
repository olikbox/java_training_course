package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void contactCreationTests() {
        app.getNavigationHelper ( ).gotoHomePage ( );
        List <ContactData> before = app.getContactHelper ( ).getContactList ( );
        ContactData contact = new ContactData ( "Koska", "Pug", "HUG ME", "Address 1", "0987655678", "totop@mail.com" );
        app.getContactHelper ( ).createContact ( contact );
        app.getNavigationHelper ( ).gotoHomePage ( );
        List <ContactData> after = app.getContactHelper ( ).getContactList ( );


        contact.setId ( after.stream ( ).max ( (o1, o2) -> Integer.compare ( o1.getId ( ), o2.getId ( ) ) ).get ( ).getId ( ) );
        Comparator <? super ContactData> byId = (c1, c2) -> Integer.compare ( c1.getId ( ), c2.getId ( ) );
        before.sort ( byId );
        after.sort ( byId );
        Assert.assertEquals(new HashSet<Object> (after), new HashSet<Object> (before));
    }
}


