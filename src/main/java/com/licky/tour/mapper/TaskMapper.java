package com.licky.tour.mapper;

import com.licky.tour.domain.Task;
import com.licky.tour.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    List<Task> selectTaskListByUsername(User user);
}