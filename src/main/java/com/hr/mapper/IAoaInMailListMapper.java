package com.hr.mapper;

import com.hr.entity.AoaInMailList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 内部邮件表
 */
@Repository
public interface IAoaInMailListMapper {

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

    /**
     * 查询发件箱
     *
     * @param paramMap
     * @return
     */
    public List<AoaInMailList> queryAoaOutMailList(Map<String, Object> paramMap);

    /**
     * 查询收件箱总条目数
     *
     * @param paramMap 参数集合
     * @return
     */
    public Long getCountForOutMailBox(Map<String, Object> paramMap);

    /**
     * 删除发件箱邮件
     *
     * @param paramMap 参数集合
     * @return
     */
    public Integer deleteForOutMail(Map<String, Object> paramMap);

    /**
     * 获取星标状态
     *
     * @param paramMap 参数集合
     * @return
     */
    public Long getStarStatus(Map<String, Object> paramMap);

    /**
     * 修改星标
     *
     * @param paramMap 参数集合
     * @return
     */
    public Integer updateAoaInMailListForStar(Map<String, Object> paramMap);
}