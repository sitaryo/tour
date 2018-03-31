package com.licky.tour.domain;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer id;

    private String username;

    private String nickname;

    private String password;

    private Boolean sex;

    private String longitude;

    private String latitude;

    private Integer authorityId;

    private Integer headPicId;

    private Integer teamId;

    private Boolean active;

    private static final long serialVersionUID = 1L;

    @Getter
    public enum Sex {
        MAN(true),
        WOMAN(false);
        Boolean s;

        Sex(boolean b) {
            this.s = b;
        }
    }
}