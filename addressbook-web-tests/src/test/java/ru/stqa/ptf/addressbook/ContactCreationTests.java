package ru.stqa.ptf.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

    @Test
    public void ContactCreationTests() {

        app.initAddContact();
        app.fillContactForm(new ContactData("Olga", "Pug", "HUG ME", "Address 1", "0987655678", "totop@mail.com", "Address 2", "No notes"));
        app.submitContactCreation();
        app.returntoHomePage();
    }

}
