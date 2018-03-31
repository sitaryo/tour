package com.licky.tour.model;

import com.licky.tour.domain.Notice;
import com.licky.tour.domain.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class NoticeUserModel implements Serializable{

    private static final long serialVersionUID = 1L;
    private Notice notice;
    private User user;
}
