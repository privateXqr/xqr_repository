package com.hr.service;

import com.hr.entity.AoaInMailList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IAoaInMailListService {

    /**
     * 新建内部邮件
     *
     * @param aoaInMailList 邮件
     * @return
     */
    public Integer addAoaMailList(AoaInMailList aoaInMailList);

    /**
     * 查询收件箱
     *
     * @param paramMap 参数集合
     * @return
     */
    public List<AoaInMailList> queryAoaInMailList(Map<String, Object> paramMap);

    /**
     * 查询收件箱总条目数
     *
     * @param paramMap 参数集合
     * @return
     */
    public Long getCountForInMailBox(Map<String, Object> paramMap);

    /**
     * 查询指定邮件
     *
     * @param paramMap 参数列表
     * @return
     */
    public AoaInMailList queryAoaInMailListWhere(Map<String, Object> paramMap);
}