package com.hr.mapper;

import com.hr.entity.AoaTaskList;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 任务表
 */
@Repository
public interface IAoaTaskListMapper {

    /**
     * 查询任务
     *
     * @param paramMap
     * @return
     */
    public List<AoaTaskList> queryAoaTaskList(Map<String, Object> paramMap);

    /**
     * 获取任务列表总元素数
     *
     * @param paramMap
     * @return
     */
    public Long getCountForTaskList(Map<String, Object> paramMap);

}