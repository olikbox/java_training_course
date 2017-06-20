package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
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
        Assert.assertEquals ( after.size ( ), before.size ( ) + 1 );

        contact.setId ( after.stream ( ).max ( (o1, o2) -> Integer.compare ( o1.getId ( ), o2.getId ( ) ) ).get ( ).getId ( ) );
        before.add ( contact );
        Comparator <? super ContactData> byId = (g1, g2) -> Integer.compare ( g1.getId ( ), g2.getId ( ) );
        before.sort ( byId );
        after.sort ( byId );
        Assert.assertEquals ( before, after );
    }
}


