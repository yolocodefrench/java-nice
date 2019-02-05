package com.esperluette.nice.domain.dto;

import com.esperluette.nice.domain.Preferences;
import com.esperluette.nice.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private String email;
    private String lname;
    private String fname;
    private Integer id;


    public UserDTO(User user){
        this.email = user.getEmail();
        this.lname = user.getLname();
        this.fname = user.getFname();
        this.id = user.getId();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
