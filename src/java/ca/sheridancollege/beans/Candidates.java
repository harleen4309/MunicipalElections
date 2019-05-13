/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.beans;

import java.io.Serializable;

/**
 * class to map Candidates table
 *
 * @author Harleen Kaur
 */
public class Candidates implements Serializable {

    private int cand_ID;
    private String first_Name;
    private String last_Name;
    private String address;
    private String email;
    private String phone;

    public Candidates(int cand_ID, String first_Name, String last_Name, String address, String email, String phone) {
        this.cand_ID = cand_ID;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public Candidates() {
        cand_ID = 0;
        first_Name = "";
        last_Name = "";
        address = "";
        email = "";
        phone = "";
    }

    public int getCand_ID() {
        return cand_ID;
    }

    public void setCand_ID(int cand_ID) {
        this.cand_ID = cand_ID;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
