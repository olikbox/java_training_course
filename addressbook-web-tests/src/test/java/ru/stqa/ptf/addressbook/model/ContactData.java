package ru.stqa.ptf.addressbook.model;

public class ContactData {
    private int id;
    private final String firstname;
    private final String lastname;
    private final String company;
    private final String address;
    private final String homephone;
    private final String firstemail;

    public ContactData(String firstname, String lastname, String company, String address, String homephone, String firstemail) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.address = address;
        this.homephone = homephone;
        this.firstemail = firstemail;
    }

    public ContactData(int id, String firstname, String lastname, String company, String address, String homephone, String firstemail) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.address = address;
        this.homephone = homephone;
        this.firstemail = firstemail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass ( ) != o.getClass ( )) return false;

        ContactData that = (ContactData) o;

        if (firstname != null ? !firstname.equals ( that.firstname ) : that.firstname != null) return false;
        return lastname != null ? lastname.equals ( that.lastname ) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode ( ) : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode ( ) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" + "id=" + id + ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' + '}';
    }

}