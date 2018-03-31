package com.licky.tour.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Task implements Serializable {
    private Integer id;

    private String title;

    private String content;

    private String longitude;

    private String latitude;

    private Date createTime;

    private Date planningTime;

    private Date completedTime;

    private Byte completedFlag;

    private Integer teamId;

    private static final long serialVersionUID = 1L;

}