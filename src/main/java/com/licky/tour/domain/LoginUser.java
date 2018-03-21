package com.licky.tour.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
public class LoginUser implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String longitude;
    private String latitude;
    private int sex;
    private Collection<Authority> authorities;

}
