package ru.stqa.ptf.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

import static ru.stqa.ptf.addressbook.tests.TestBase.app;

/**
 * Created by Olga_Verkhovtseva on 5/23/2017.
 */
public class ContactHelper extends BaseHelper {

    WebDriver Driver;
    private NavigationHelper navigationHelper;

    public ContactHelper(WebDriver wd) {
        super(wd);
        Driver = wd;
    }

    public void initAddContact() {
        click(By.xpath("//*[@id=\"nav\"]/ul/li[2]/a"));
    }

    public void fillContactForm(ContactData ContactData) {
        type(By.name("firstname"), ContactData.getFirstname());
        type(By.name("lastname"), ContactData.getLastname());
        type(By.name("company"), ContactData.getCompany());
        type(By.name("address"), ContactData.getAddress());
        type(By.name("home"), ContactData.getHomephone());
        type(By.name("email"), ContactData.getFirstemail());
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void selectContactModification(int index) {
        click(By.name("selected[]"));
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.xpath("//*[@id=\"content\"]/form[1]/input[22]"));
    }

    public void submitContactDelete() {
        click(By.xpath("//*[@id=\"content\"]/form[2]/input[2]"));
    }

    public boolean IsThereAContact() {
        return isElementPresent(By.name("entry"));
    }

    public void createContact(ContactData contact) {
        gotoAddContactPage();
        initAddContact();
        fillContactForm (contact);
        submitContactCreation();
        app.getNavigationHelper ( ).gotoHomePage ( );
    }

    public void gotoAddContactPage() {
        {
            click(By.linkText("add new"));
        }

    }

    public int getContactCount() {
        return wd.findElements ( By.name ( "selected[]" ) ).size ( );
    }

    public List <ContactData> getContactList() {
        List <ContactData> contacts = new ArrayList <> ( );
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData ().withId ( id).withFirstname ( firstname).withLastname ( lastname );
            contacts.add ( contact );
        }
        return contacts;
    }

    public void selectContact(int index) {
        wd.findElements ( By.name ( "selected[]" ) ).get ( index ).click ( );
    }

    public void deleteSelectedContacts() {
        click ( By.xpath ( "//input[@value='Delete']" ) );
        wd.switchTo ( ).alert ( ).accept ( );
    }

    public void editContactForm(ContactData contact) {
        type(By.name("firstname"), contact.getFirstname());
        type(By.name("lastname"), contact.getLastname());
        type(By.name("company"), contact.getCompany());
        type(By.name("address"), contact.getAddress());
        type(By.name("home"), contact.getHomephone());
        type(By.name("email"), contact.getFirstemail());
    }

    public void modifyContact(int index, ContactData contact) {
        selectContactModification ( index );
        initContactModification ( );
        editContactForm ( contact );
        submitContactModification ( );
        app.getNavigationHelper ( ).returntoHomePage ( );
    }

    public void deleteContact(int index) {
        selectContact ( index );
        deleteSelectedContacts ( );
        app.getNavigationHelper ( ).gotoHomePage ( );
    }


}

