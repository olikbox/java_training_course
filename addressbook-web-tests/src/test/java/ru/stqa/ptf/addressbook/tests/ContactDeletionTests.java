package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by Olga_Verkhovtseva on 5/24/2017.
 */
public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper ( ).gotoHomePage ( );
        if (!app.getContactHelper ( ).IsThereAContact ( )) {
            app.getContactHelper ( ).createContact ( new ContactData ( "Koska", "Pug", "HUG ME", "Address 1", "0987655678", "totop@mail.com" ) );
        }
    }

    @Test
    public void contactDeletionTests() {
        List <ContactData> before = app.getContactHelper ( ).getContactList ( );
        int index = before.size ( ) - 1;
        app.getContactHelper().deleteContact ( index );
        List <ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),index);

        before.remove(index);
        Assert.assertEquals(before, after);
    }


}

