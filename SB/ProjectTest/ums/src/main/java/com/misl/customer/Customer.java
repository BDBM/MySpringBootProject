package com.misl.customer;

public class Customer {

    private long id;
    private String name;
    private String fathername;
    private String mothername;
    private String phone;

    public Customer(){

    }
    public Customer(long id, String name, String fathername, String mothername, String phone) {
        this.id = id;
        this.name = name;
        this.fathername = fathername;
        this.mothername = mothername;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
