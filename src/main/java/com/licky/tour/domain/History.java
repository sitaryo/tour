package com.licky.tour.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class History implements Serializable {
    private Integer id;

    private Integer teamId;

    private Integer userId;

    private static final long serialVersionUID = 1L;
}