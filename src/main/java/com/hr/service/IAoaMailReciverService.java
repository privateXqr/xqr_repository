package com.hr.service;

import java.util.List;
import java.util.Map;

public interface IAoaMailReciverService {

    /**
     * 为用户所发的内部邮件 与所有收件人建立关系
     *
     * @param mailId     内部邮件ID
     * @param userId 用户ID
     * @return
     */
    public Integer addAoaMailReciver(Long mailId, Long userId);

    /**
     * 批量删除内部邮件与收件人中间关系
     *
     * @param paramMap 参数集合
     * @return
     */
    public Integer batchDeleteAoaMailReciver(Map<String, Object> paramMap);

    /**
     * 设置邮件已读
     *
     * @param paramMap 参数集合
     * @return
     */
    public Integer batchUpdateAoaMailReciverForRead(Map<String, Object> paramMap);

    /**
     * 设置星标
     *
     * @param paramMap 参数集合
     * @return
     */
    public Integer batchUpdateAoaMailReciverForStar(Map<String, Object> paramMap);
}
