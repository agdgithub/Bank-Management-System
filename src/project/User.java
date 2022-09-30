/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Date;

/**
 *
 * @author jayes
 */
public class User {
    
    private String name;
    private Date DOB;
    private String address;
    private String gender;
    private String email;
    private String mobile;

    public User(String name, Date DOB, String address, String gender, String email, String mobile) {
        this.name = name;
        this.DOB = DOB;
        this.address = address;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
    }
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String toString()
    {
            return  name + "\n" + DOB + "\n" + address + "\n" + gender + "\n" +email +"\n"+mobile;
    }
}

