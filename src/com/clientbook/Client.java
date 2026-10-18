package com.clientbook;

public class Client {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String company;

    public Client(int id, String name, String phone, String email, String company) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + "\nName: " + name
                + "\nPhone: " + phone
                + "\nEmail: " + email
                + "\nCompany: " + company;
    }
}
