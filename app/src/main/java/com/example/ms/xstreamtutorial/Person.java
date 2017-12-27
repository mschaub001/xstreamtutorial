package com.example.ms.xstreamtutorial;

class Person {
    private String firstname;
    private String lastname;
    private String phone;
    private String email;

    Person() {
        firstname = null;
        lastname = null;
        email = null;
        phone = null;
    }

    Person(String p_firstame, String p_lastname, String p_phone, String p_email) {
        firstname = p_firstame;
        lastname = p_lastname;
        email = p_email;
        phone = p_phone;
    }

    void setFirstname(String n) {
        firstname = n;
    }

    void setLastname(String n) {
        lastname = n;
    }

    void setPhone(String n) {
        phone = n;
    }

    void setEmail(String n) {
        email = n;
    }

    String getFirstname() {
        return firstname;
    }

    String getLastname() {
        return lastname;
    }

    String getPhone() {
        return phone;
    }

    String getEmail() {
        return email;
    }


}

