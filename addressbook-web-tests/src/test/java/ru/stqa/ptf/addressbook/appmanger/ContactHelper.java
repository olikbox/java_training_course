package ru.stqa.ptf.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga_Verkhovtseva on 5/23/2017.
 */
public class ContactHelper extends BaseHelper {

    WebDriver Driver;
    public ContactHelper(WebDriver wd) {
        super(wd);
        Driver = wd;
    }

    public void initAddContact() {
        click(By.xpath("//*[@id=\"nav\"]/ul/li[2]/a"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomephone());
        type(By.name("email"), contactData.getFirstemail());
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void selectContactModification() {
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

    public void createContact(ContactData contactData) {
        gotoAddContactPage();
        initAddContact();
        fillContactForm ( new ContactData ( "AAA", "Pug", "HUG ME", "Address 1", "0987655678", "totop@mail.com" ) );
        submitContactCreation();
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
            ContactData contact = new ContactData ( id, firstname, lastname, null, null, null, null );
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
}

