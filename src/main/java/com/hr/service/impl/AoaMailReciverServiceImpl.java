package com.hr.service.impl;

import com.hr.mapper.IAoaMailReciverMapper;
import com.hr.service.IAoaMailReciverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AoaMailReciverServiceImpl implements IAoaMailReciverService {

    @Autowired
    private IAoaMailReciverMapper aoaMailReciverMapper;

    @Override
    public Integer addAoaMailReciver(Long mailId, Long userId) {
        return aoaMailReciverMapper.addAoaMailReciver(mailId,userId);
    }
}
