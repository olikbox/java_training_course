package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Olga_Verkhovtseva on 5/24/2017.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper ( ).gotoHomePage ( );
        if (!app.getContactHelper ( ).IsThereAContact ( )) {
            app.getContactHelper ( ).createContact ( new ContactData ().withFirstname("Koska").withLastname ("Pug").withCompany ( "HUG ME").withAddress ( "Address 1").withHomephone ( "0987655678").withFirstemail ( "totop@mail.com" ));
        }
    }

    @Test

    public void contactModificationTests() {
        List <ContactData> before = app.getContactHelper ( ).getContactList ( );
        int index = before.size ( ) - 1;
        ContactData contact = new ContactData().withFirstname("Koska2").withLastname ("Pug2").withCompany ( "HUG ME").withAddress ( "Address 1").withHomephone ( "0987655678").withFirstemail ( "totop@mail.com" );
        app.getContactHelper ( ).modifyContact ( index, contact );
        List <ContactData> after = app.getContactHelper ( ).getContactList ( );
        Assert.assertEquals ( after.size ( ), before.size ( ) );


        before.remove ( index );
        before.add(contact);
        Comparator <? super ContactData> byId  = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals (before,after);
    }


}