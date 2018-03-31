package com.licky.tour.model;

import com.licky.tour.domain.Preparation;
import com.licky.tour.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvitePreparationModel {
    private String invitedUsername;

    private String guideUsername;
}
