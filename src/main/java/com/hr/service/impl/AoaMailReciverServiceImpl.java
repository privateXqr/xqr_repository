package com.hr.service.impl;

import com.hr.entity.AoaInMailList;
import com.hr.mapper.IAoaMailReciverMapper;
import com.hr.service.IAoaMailReciverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AoaMailReciverServiceImpl implements IAoaMailReciverService {

    @Autowired
    private IAoaMailReciverMapper aoaMailReciverMapper;

    @Override
    public Integer addAoaMailReciver(Long mailId, Long userId) {
        return aoaMailReciverMapper.addAoaMailReciver(mailId,userId);
    }

    @Override
    public Integer batchDeleteAoaMailReciver(Map<String, Object> paramMap) {
        return aoaMailReciverMapper.batchDeleteAoaMailReciver(paramMap);
    }

    @Override
    public Integer batchUpdateAoaMailReciverForRead(Map<String, Object> paramMap) {
        return aoaMailReciverMapper.batchUpdateAoaMailReciverForRead(paramMap);
    }

    @Override
    public Long getStarStatus(Map<String, Object> paramMap) {
        return aoaMailReciverMapper.getStarStatus(paramMap);
    }

    @Override
    public Integer updateAoaMailReciverForStar(Map<String, Object> paramMap) {
        return aoaMailReciverMapper.updateAoaMailReciverForStar(paramMap);
    }

    @Override
    public Integer batchRealDeleteAoaMailReciver(Map<String, Object> paramMap) {
        return aoaMailReciverMapper.batchRealDeleteAoaMailReciver(paramMap);
    }
}
