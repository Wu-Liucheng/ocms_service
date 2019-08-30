package com.ocms.entities;

import java.util.Date;

public class Client {
    private Long id;

    private String customerNumber;

    private Boolean isDel;

    private String corporateName;

    private String corporateAddress;

    private String contacts;

    private String contactsTel;

    private String contactsEmail;

    private Boolean isEffective;

    private String introduction;

    private String invoiceCustomerName;

    private String taxPayerIdentificationNum;

    private String address;

    private String telephone;

    private String bank;

    private String bankAccount;

    private String summary;

    private Long createdBy;

    private Date createDate;

    private Long lastUpdateBy;

    private Date lastUpdateDate;

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
        this.customerNumber = customerNumber == null ? null : customerNumber.trim();
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName == null ? null : corporateName.trim();
    }

    public String getCorporateAddress() {
        return corporateAddress;
    }

    public void setCorporateAddress(String corporateAddress) {
        this.corporateAddress = corporateAddress == null ? null : corporateAddress.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getContactsTel() {
        return contactsTel;
    }

    public void setContactsTel(String contactsTel) {
        this.contactsTel = contactsTel == null ? null : contactsTel.trim();
    }

    public String getContactsEmail() {
        return contactsEmail;
    }

    public void setContactsEmail(String contactsEmail) {
        this.contactsEmail = contactsEmail == null ? null : contactsEmail.trim();
    }

    public Boolean getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Boolean isEffective) {
        this.isEffective = isEffective;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getInvoiceCustomerName() {
        return invoiceCustomerName;
    }

    public void setInvoiceCustomerName(String invoiceCustomerName) {
        this.invoiceCustomerName = invoiceCustomerName == null ? null : invoiceCustomerName.trim();
    }

    public String getTaxPayerIdentificationNum() {
        return taxPayerIdentificationNum;
    }

    public void setTaxPayerIdentificationNum(String taxPayerIdentificationNum) {
        this.taxPayerIdentificationNum = taxPayerIdentificationNum == null ? null : taxPayerIdentificationNum.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Long lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Client() {
    }

    public Client(Long id, String customerNumber, Boolean isDel, String corporateName, String corporateAddress, String contacts, String contactsTel, String contactsEmail, Boolean isEffective, String introduction, String invoiceCustomerName, String taxPayerIdentificationNum, String address, String telephone, String bank, String bankAccount, String summary, Long createdBy, Date createDate, Long lastUpdateBy, Date lastUpdateDate) {
        this.id = id;
        this.customerNumber = customerNumber;
        this.isDel = isDel;
        this.corporateName = corporateName;
        this.corporateAddress = corporateAddress;
        this.contacts = contacts;
        this.contactsTel = contactsTel;
        this.contactsEmail = contactsEmail;
        this.isEffective = isEffective;
        this.introduction = introduction;
        this.invoiceCustomerName = invoiceCustomerName;
        this.taxPayerIdentificationNum = taxPayerIdentificationNum;
        this.address = address;
        this.telephone = telephone;
        this.bank = bank;
        this.bankAccount = bankAccount;
        this.summary = summary;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", customerNumber='" + customerNumber + '\'' +
                ", isDel=" + isDel +
                ", corporateName='" + corporateName + '\'' +
                ", corporateAddress='" + corporateAddress + '\'' +
                ", contacts='" + contacts + '\'' +
                ", contactsTel='" + contactsTel + '\'' +
                ", contactsEmail='" + contactsEmail + '\'' +
                ", isEffective=" + isEffective +
                ", introduction='" + introduction + '\'' +
                ", invoiceCustomerName='" + invoiceCustomerName + '\'' +
                ", taxPayerIdentificationNum='" + taxPayerIdentificationNum + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", bank='" + bank + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", summary='" + summary + '\'' +
                ", createdBy=" + createdBy +
                ", createDate=" + createDate +
                ", lastUpdateBy=" + lastUpdateBy +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}