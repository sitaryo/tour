package com.licky.tour.domain;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
public class Preparation implements Serializable {
    private Integer id;

    private Integer teamId;

    private Integer userId;

    private Integer type;

    private static final long serialVersionUID = 1L;

    @Getter
    public enum TYPE {
        // Others can be added here manually in the future.
        INVITE(1),JOIN(2);
        private int cd ;

        TYPE(int i) {
            this.cd = i;
        }
    }
}