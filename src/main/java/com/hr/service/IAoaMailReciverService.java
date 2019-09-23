package com.hr.service;

import java.util.List;

public interface IAoaMailReciverService {

    /**
     * 为用户所发的内部邮件 与所有收件人建立关系
     *
     * @param mailId     内部邮件ID
     * @param userId 用户ID
     * @return
     */
    public Integer addAoaMailReciver(Long mailId, Long userId);
}
