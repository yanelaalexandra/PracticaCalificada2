package com.pachacama.segundocalificado.practicacalificada2.models;


import com.orm.dsl.Table;

@Table
public class User {

    private Long id;
    private String username;
    private String password;
    private String fullname;
    private String email;

    public User() {
    }

    public User(String username, String fullname, String email, String password) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;

    }




    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\''+
                '}';
    }
}