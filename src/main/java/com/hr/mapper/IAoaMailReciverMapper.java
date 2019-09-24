package com.hr.mapper;

import com.hr.entity.AoaMailReciver;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 内部邮件与收件人中间表
 */
@Repository
public interface IAoaMailReciverMapper {

    /**
     * 为用户所发的内部邮件 与所有收件人建立关系
     *
     * @param mailId 内部邮件ID
     * @param userId 用户ID
     * @return
     */
    public Integer addAoaMailReciver(@Param("mailId") Long mailId, @Param("userId") Long userId);

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