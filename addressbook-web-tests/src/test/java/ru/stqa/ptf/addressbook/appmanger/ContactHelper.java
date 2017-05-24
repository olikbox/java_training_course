package ru.stqa.ptf.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.ptf.addressbook.model.ContactData;

/**
 * Created by Olga_Verkhovtseva on 5/23/2017.
 */
public class ContactHelper extends BaseHelper {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void initAddContact() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomephone());
        type(By.name("email"), contactData.getFirstemail());
        type(By.name("address2"), contactData.getAddress2());
        type(By.name("notes"), contactData.getNotes());
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void selectContactModification() {
        click(By.name("selected[]"));
    }

    public void initContactModification() {
        click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[3]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.xpath("//*[@id=\"content\"]/form[1]/input[22]"));
    }

    public void submitContactDelete() {
        click(By.xpath("//*[@id=\"content\"]/form[2]/input[2]"));
    }
}

