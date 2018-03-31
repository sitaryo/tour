package com.licky.tour.service;

import com.licky.tour.domain.Notice;
import com.licky.tour.domain.User;
import com.licky.tour.mapper.NoticeMapper;
import com.licky.tour.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private UserMapper userMapper;

    public Optional<List<Notice>> selectNoticeInTeam(User user){
        return Optional.ofNullable(noticeMapper.selectNoticeInTeam(user));
    }

    /**
     *  根据角色所在team ，插入 notice
     * @param notice 要插入的notice
     * @param user team内的user 应为导游
     * @return true/false
     */
    public Boolean createNotice(Notice notice,User user){
        final Boolean[] insertFlag = {false};
        Optional.ofNullable(userMapper.selectByUsername(user.getUsername()))
                .ifPresent(dbUser -> {
                    Integer teamId = Optional.ofNullable(dbUser.getTeamId())
                            .orElseThrow(()->new RuntimeException("没有创建队伍"));
                    notice.setTeamId(teamId);
                    //notice.setCreateTime();
                    noticeMapper.insert(notice);
                    insertFlag[0] = true;
                });
        return insertFlag[0];
    }

    /**
     * 将notice active设为 flase
     * @param notice
     * @return
     */
    public Boolean setNoticeActiveFalse(Notice notice){
        return noticeMapper.updateByPrimaryKeySelective(notice)==1?true:false;
    }

    /**
     * 根据id获取notice
     *
     * @param noticeId id
     * @return Optional<Notice>
     */
    public Optional<Notice> selectNoticeById(Integer noticeId){
        return Optional.ofNullable(noticeMapper.selectByPrimaryKey(noticeId));
    }
}
