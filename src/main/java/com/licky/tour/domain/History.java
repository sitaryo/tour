package com.licky.tour.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class History  implements Serializable{

    private Long id;
    private LoginUser user;
    private Team team;

}
