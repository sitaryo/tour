package com.licky.tour.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Team implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;
}