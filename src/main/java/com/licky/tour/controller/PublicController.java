package com.licky.tour.controller;

import com.licky.tour.domain.User;
import com.licky.tour.service.NoticeService;
import com.licky.tour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private NoticeService noticeService;

    /**
     * 根据用户所在的 team 获取所有 user
     *
     * @param user user
     * @return List<User>
     */
    @PostMapping("/getTeamMember")
    @ResponseBody
    public Map<String, Object> getTeamMember(@RequestBody User user) {
        Map<String, Object> data = new HashMap<>(1);
        userService.selectUsersInSameTeam(user).ifPresent(users -> data.put("userList", users));
        return data;
    }

    /**
     * 根据用户所在的 team 获取所有 active 为 true 的 notice
     *
     * @param user user
     * @return List<Notice>
     */
    @PostMapping("/getTeamNotice")
    @ResponseBody
    public Map<String, Object> getTeamNotice(@RequestBody User user) {
        Map<String, Object> data = new HashMap<>(1);
        noticeService.selectNoticeInTeam(user).ifPresent(notices -> {
            notices.stream()
                    .filter(notice -> notice.getActive().booleanValue() == true)
                    .collect(Collectors.toList());
            data.put("noticeList", notices);
        });
        return data;
    }

    @GetMapping("/getTeamNoticeDetail/{notice_id}")
    @ResponseBody
    public Map<String,Object> getTeamNoticeDetail(@PathVariable("notice_id")Integer noticeId){
        Map<String,Object> data = new HashMap<>(1);
        noticeService.selectNoticeById(noticeId).ifPresent(notice -> data.put("notice",notice));
        return data;
    }

    @PostMapping("/updatePersonalMessage")
    @ResponseBody
    public  Map<String ,Object> updatePersonalMessage(@RequestBody User user){
        Map<String,Object> data = new HashMap<>(1);
        data.put("updateFlag",userService.updateBaseInfoByUserName(user));
        return data;
    }

    @PostMapping("/resetPassword")
    @ResponseBody
    public Map<String,Object> resetPassword(@RequestBody User user){
        Map<String,Object> data = new HashMap<>(1);
        data.put("resetFlag",userService.resetPasswordByUsername(user));
        return data;
    }
}
