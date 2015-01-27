/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1201projekt.util;

import java.util.List;

/**
 *
 * @author Kim
 */
public class RecruiterDTO {
    
    private int id;
    private String name;
    private String surname;
    private String ssn;
    private String email;
    private String role;
    private final String username;
    private Availability availability;

    public RecruiterDTO(String name, String surname, String ssn, String email, String role, String username, List<Competence> competences, Availability availability) {
        this.name = name;
        this.surname = surname;
        this.ssn = ssn;
        this.email = email;
        this.role = role;
        this.username = username;
        this.availability = availability;
    }

    public RecruiterDTO(int id, String name, String surname, String ssn, String email, String role, String username, List<Competence> competences, Availability availability) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.ssn = ssn;
        this.email = email;
        this.role = role;
        this.username = username;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSsn() {
        return ssn;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public Availability getAvailability() {
        return availability;
    }
}