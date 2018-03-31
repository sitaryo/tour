package com.licky.tour.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class Authority implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;

    public enum Role {
        // Others can be added here manually in the future.
        USER, GUIDE,COMPANY
    }

}