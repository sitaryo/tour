package com.licky.tour.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
public class Team  implements Serializable{

    private Long id;
    private String name;
    private Collection<LoginUser> users;

}
