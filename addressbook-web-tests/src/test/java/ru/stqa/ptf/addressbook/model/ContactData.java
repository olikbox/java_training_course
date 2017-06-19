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
    public String toString() {
        return "ContactData{" + "id=" + id + ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactData)) return false;

        ContactData that = (ContactData) o;

        if (getId ( ) != that.getId ( )) return false;
        if (getFirstname ( ) != null ? !getFirstname ( ).equals ( that.getFirstname ( ) ) : that.getFirstname ( ) != null)
            return false;
        return getLastname ( ) != null ? getLastname ( ).equals ( that.getLastname ( ) ) : that.getLastname ( ) == null;
    }

    @Override
    public int hashCode() {
        int result = getId ( );
        result = 31 * result + (getFirstname ( ) != null ? getFirstname ( ).hashCode ( ) : 0);
        result = 31 * result + (getLastname ( ) != null ? getLastname ( ).hashCode ( ) : 0);
        return result;
    }
}