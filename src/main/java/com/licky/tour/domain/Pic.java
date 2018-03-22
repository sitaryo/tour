package com.licky.tour.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class Pic implements Serializable {
    private Integer id;

    private String src;

    private String longitude;

    private String latitude;

    private Integer userId;

    private Integer journeyId;

    private static final long serialVersionUID = 1L;
}