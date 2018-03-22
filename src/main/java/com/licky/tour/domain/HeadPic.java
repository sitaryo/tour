package com.licky.tour.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class HeadPic implements Serializable {
    private Integer id;

    private String src;

    private Integer userId;

    private static final long serialVersionUID = 1L;
}