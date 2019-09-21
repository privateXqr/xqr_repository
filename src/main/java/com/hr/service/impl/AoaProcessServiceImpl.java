package com.hr.service.impl;

import com.hr.entity.*;
import com.hr.mapper.*;
import com.hr.service.IAoaProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AoaProcessServiceImpl implements IAoaProcessService {

    @Autowired
    private IAoaBursementMapper iAoaBursementMapper;

    @Autowired
    private IAoaOvertimeMapper iAoaOvertimeMapper;

    @Autowired
    private IAoaEvectionMapper iAoaEvectionMapper;

    @Autowired
    private IAoaRegularMapper iAoaRegularMapper;

    @Autowired
    private IAoaHolidayMapper iAoaHolidayMapper;

    @Autowired
    private IAoaResignMapper iAoaResignMapper;

    @Autowired
    private IAoaProcessListMapper iAoaProcessListMapper;

    @Override
    public void addBursement(AoaBursement aoaBursement) {

    }

    @Override
    public void addEvection(AoaEvection aoaEvection) {

    }

    @Override
    public void addOvertime(AoaOvertime aoaOvertime) {

    }

    @Override
    public void addRegular(AoaRegular aoaRegular) {

    }

    @Override
    public void addHoliday(AoaHoliday aoaHoliday) {

    }

    @Override
    public void addResign(AoaRegular aoaRegular) {

    }

    @Override
    public List<AoaProcessList> queryMyApplyFor(AoaProcessList aoaProcessList) {

        return iAoaProcessListMapper.queryMyApplyFor(aoaProcessList);
    }

    @Override
    public void addAoaProcessList(AoaProcessList aoaProcessList) {

    }
}
