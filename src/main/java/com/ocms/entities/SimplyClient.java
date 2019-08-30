package com.ocms.entities;

public class SimplyClient {
    private String key;
    private Long id;
    private String customerNumber;
    private String corporateName;
    private String contacts;
    private String contactsTel;
    private String contactsEmail;

    public SimplyClient(Long id, String customerNumber, String corporateName, String contacts, String contactsTel, String contactsEmail) {
        this.id = id;
        this.customerNumber = customerNumber;
        this.corporateName = corporateName;
        this.contacts = contacts;
        this.contactsTel = contactsTel;
        this.contactsEmail = contactsEmail;
    }

    public SimplyClient(String key, Long id, String customerNumber, String corporateName, String contacts, String contactsTel, String contactsEmail) {
        this.key = key;
        this.id = id;
        this.customerNumber = customerNumber;
        this.corporateName = corporateName;
        this.contacts = contacts;
        this.contactsTel = contactsTel;
        this.contactsEmail = contactsEmail;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactsTel() {
        return contactsTel;
    }

    public void setContactsTel(String contactsTel) {
        this.contactsTel = contactsTel;
    }

    public String getContactsEmail() {
        return contactsEmail;
    }

    public void setContactsEmail(String contactsEmail) {
        this.contactsEmail = contactsEmail;
    }
}
