package com.licky.tour.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Journey implements Serializable {
    private Integer id;

    private String title;

    private String route;

    private Integer userId;

    private static final long serialVersionUID = 1L;

}