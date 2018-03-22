package com.licky.tour.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Notice implements Serializable {
    private Integer id;

    private String title;

    private String content;

    private Integer teamId;

    private static final long serialVersionUID = 1L;
}