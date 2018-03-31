package com.licky.tour.controller;

import com.licky.tour.domain.Authority;
import com.licky.tour.domain.Notice;
import com.licky.tour.domain.Preparation;
import com.licky.tour.domain.User;
import com.licky.tour.model.InvitePreparationModel;
import com.licky.tour.model.NoticeUserModel;
import com.licky.tour.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/guide")
public class GuideController {

    @Autowired
    private UserService userService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private PreparationService preparationService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private AuthorityService authorityService;

    /**
     * 根据角色所在team 增加该team的notice
     *
     * @param noticeUserModel 包含 notice 基本信息 与 user 根据user获取所属team
     * @return true/false
     */
    @PostMapping("/newNotice")
    @ResponseBody
    public Map<String, Object> newNotice(@RequestBody NoticeUserModel noticeUserModel) {
        noticeUserModel.getNotice().setActive(true);
        noticeUserModel.getNotice().setCreateTime(new Date());
        Map<String, Object> data = new HashMap(1);
        data.put("insertFlag"
                , noticeService.createNotice(noticeUserModel.getNotice(), noticeUserModel.getUser()));
        return data;
    }

    /**
     * 根据notice id 字段跟新 active 设为false
     *
     * @param notice 只传入 id
     * @return true/false
     */
    @PostMapping("/deleteNotice")
    @ResponseBody
    public Map<String, Object> deleteNotice(@RequestBody Notice notice) {
        Map<String, Object> data = new HashMap<>(1);
        notice.setActive(false);
        data.put("deleteFlag", noticeService.setNoticeActiveFalse(notice));
        return data;
    }

    /**
     * 根据用户名移除该用户当前的 team_id 属性
     *
     * @param user
     * @return
     */
    @PostMapping("/removeMember")
    @ResponseBody
    public Map<String, Object> removeMember(@RequestBody User user) {
        Map<String, Object> data = new HashMap<>(1);
        data.put("removeFlag", userService.removeUserFromTeam(user));
        return data;
    }

    /**
     * 根据邀请者与被邀请者的 username 插入预加入表
     *
     * @param model InvitePreparationModel
     * @return true/false
     */
    @PostMapping("/inviteMember")
    @ResponseBody
    public Map<String, Object> inviteMember(@RequestBody InvitePreparationModel model) {
        Map<String, Object> data = new HashMap<>(1);
        Preparation preparation = new Preparation();
        userService.selectUserByUsername(model.getGuideUsername())
                .ifPresent(user -> preparation.setTeamId(user.getTeamId()));
        userService.selectUserByUsername(model.getInvitedUsername())
                .ifPresent(user -> preparation.setUserId(user.getId()));
        preparation.setType(Preparation.TYPE.INVITE.getCd());
        data.put("createFlag", preparationService.createPreparation(preparation));
        return data;
    }

    /**
     * 根据 username 判断当前角色是否为 GUIDE ，是则返回当前 team 的 taskList
     * @param user user
     * @return taskList
     */
    @PostMapping("/taskList")
    @ResponseBody
    public Map<String, Object> getTaskList(@RequestBody User user) {
        Map<String, Object> data = new HashMap<>(1);
        userService.selectUserByUsername(user.getUsername()).ifPresent(dbUser ->{
            if(Authority.Role.GUIDE.toString().equals(authorityService.selectAuthorityById(dbUser.getAuthorityId())
                    .orElseGet(Authority::new).getName())){
                taskService.getTaskListByUserName(dbUser).ifPresent(tasks ->
                        data.put("taskList",tasks));
            }});
        return data;
    }

}
