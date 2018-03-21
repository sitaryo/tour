package com.licky.tour.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Collection;

@Data
public class Authority  implements GrantedAuthority, Serializable {

    private Long id;
    private String name;

    private String authority;

    @ManyToMany(mappedBy = "authorities")
    private Collection<LoginUser> users;

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public enum Role {
        // Others can be added here manually in the future.
        USER, SUPERUSER
    }
}
