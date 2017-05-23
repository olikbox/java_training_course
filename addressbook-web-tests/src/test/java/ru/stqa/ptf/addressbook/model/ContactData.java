package ru.stqa.ptf.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String company;
    private final String address;
    private final String homephone;
    private final String firstemail;
    private final String address2;
    private final String notes;

    public ContactData(String firstname, String lastname, String company, String address, String homephone, String firstemail, String address2, String notes) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.address = address;
        this.homephone = homephone;
        this.firstemail = firstemail;
        this.address2 = address2;
        this.notes = notes;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomephone() {
        return homephone;
    }

    public String getFirstemail() {
        return firstemail;
    }

    public String getAddress2() {
        return address2;
    }

    public String getNotes() {
        return notes;
    }
}
