package com.hr.service.impl;

import com.hr.entity.AoaTaskList;
import com.hr.mapper.IAoaTaskListMapper;
import com.hr.service.IAoaTaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AoaTaskListServiceImpl implements IAoaTaskListService {

    @Autowired
    private IAoaTaskListMapper aoaTaskListMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AoaTaskList> queryAoaTaskList(Map<String, Object> paramMap) {
        return aoaTaskListMapper.queryAoaTaskList(paramMap);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long getCountForTaskList(Map<String, Object> paramMap) {
        return aoaTaskListMapper.getCountForTaskList(paramMap);
    }
}
