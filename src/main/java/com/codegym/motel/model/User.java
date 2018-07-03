package com.codegym.motel.model;

public class User {

    final static int HOST = 1;
    final static int GUEST = 2;

    private int id;
    private String name;
    private String password;
    private String birthday;
    private String identification;
    private String phone;
    private String hometown;
    private boolean gender;
    private String email;
    private int typeOfAccount;

    public User() {
    }

    public User(int id, String name, String password, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public User(int id, String name, String password, String birthday, String identification, String phone, String hometown, boolean gender, String email, int typeOfAccount) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birthday = birthday;
        this.identification = identification;
        this.phone = phone;
        this.hometown = hometown;
        this.gender = gender;
        this.email = email;
        this.typeOfAccount = typeOfAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTypeOfAccount() {
        return typeOfAccount;
    }

    public void setTypeOfAccount(int typeOfAccount) {
        this.typeOfAccount = typeOfAccount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", identification='" + identification + '\'' +
                ", phone='" + phone + '\'' +
                ", hometown='" + hometown + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", typeOfAccount=" + typeOfAccount +
                '}';
    }
}
