package com.licky.tour.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private Byte sex;

    private String longitude;

    private String latitude;

    private Integer authorityId;

    private Integer headPicId;

    private Integer teamId;

    private static final long serialVersionUID = 1L;
}