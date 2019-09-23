package com.hr.service.impl;

import com.hr.entity.*;
import com.hr.mapper.*;
import com.hr.service.IAoaProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 流程管理服务实现
 */

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
        iAoaProcessListMapper.addAoaProcessList(aoaProcessList);
}

    @Override
    public AoaProcessList queryMyApplyForById(AoaPlanList aoaPlanList) {
        return iAoaProcessListMapper.queryMyApplyForById(aoaPlanList);
    }

    @Override
    public List<AoaProcessList> queryApplyFor() {
        return iAoaProcessListMapper.queryApplyFor();
    }

    @Override
    public AoaProcessList queryApplyForById(AoaProcessList id) {
        return iAoaProcessListMapper.queryApplyForById(id);
    }

    @Override
    public void updateApplyFor(AoaProcessList id) {
        iAoaProcessListMapper.updateApplyFor(id);
    }
}
