package com.licky.tour.service;

import com.licky.tour.domain.Authority;
import com.licky.tour.mapper.AuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorityService {
    @Autowired
    private AuthorityMapper authorityMapper;

    public Optional<Authority> selectAuthorityById(Integer id){
        return Optional.ofNullable(authorityMapper.selectByPrimaryKey(id));
    }
}
