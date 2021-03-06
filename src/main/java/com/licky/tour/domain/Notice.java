package com.licky.tour.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Notice implements Serializable {
    private Integer id;

    private String title;

    private String content;

    private Integer teamId;

    private Boolean active;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

}