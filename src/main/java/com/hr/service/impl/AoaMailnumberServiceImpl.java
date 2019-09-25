package com.hr.service.impl;

import com.hr.entity.AoaMailnumber;
import com.hr.mapper.IAoaMailnumberMapper;
import com.hr.service.IAoaMailnumberService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AoaMailnumberServiceImpl implements IAoaMailnumberService{

    @Autowired
    private IAoaMailnumberMapper aoaMailnumberMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public AoaMailnumber existsAoaMailnumber(@Param("mailAccount") String mailAccount) {
        return aoaMailnumberMapper.existsAoaMailnumber(mailAccount);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AoaMailnumber> queryAoaMailNumberByMailAccount(Map<String, Object> paramMap) {
        return aoaMailnumberMapper.queryAoaMailNumberByMailAccount(paramMap);
    }
}
