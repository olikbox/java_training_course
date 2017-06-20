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
        ContactData contact = new ContactData().withFirstname ("Olga").withLastname ("Pug").withCompany ( "HUG ME").withAddress ( "Address 1").withHomephone ( "0987655678").withFirstemail ( "totop@mail.com" );
        app.getContactHelper ( ).createContact ( contact );
        List <ContactData> after = app.getContactHelper ( ).getContactList ( );
        Assert.assertEquals ( after.size ( ), before.size ( ) + 1 );

        contact.withId ( after.stream ( ).max ( (o1, o2) -> Integer.compare ( o1.getId ( ), o2.getId ( ) ) ).get ( ).getId ( ) );
        before.add ( contact );
        Comparator <? super ContactData> byId = (g1, g2) -> Integer.compare ( g1.getId ( ), g2.getId ( ) );
        before.sort ( byId );
        after.sort ( byId );
        Assert.assertEquals ( before, after );
    }
}


