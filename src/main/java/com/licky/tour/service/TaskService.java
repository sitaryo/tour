package com.licky.tour.service;

import com.licky.tour.domain.Task;
import com.licky.tour.domain.User;
import com.licky.tour.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    public Optional<List<Task>> getTaskListByUserName(User user){
        return Optional.ofNullable(taskMapper.selectTaskListByUsername(user));
    }

}
