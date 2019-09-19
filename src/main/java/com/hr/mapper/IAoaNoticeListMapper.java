package com.hr.mapper;

import com.hr.entity.AoaNoticeList;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 通知总表
 */
public interface IAoaNoticeListMapper {
    //查询通知
    List<AoaNoticeList> queryAoaNoticeListAll();

    //通过ID查询通知对象
    AoaNoticeList queryByAoaNoticeListId(int id);

    //修改通知
    void updateAoaNoticeList(AoaNoticeList aoaNoticeList);

    //删除通知
    void delAoaNoticeList(int id);

    //新增通知
    void addiAoaNoticeList(AoaNoticeList aoaNoticeList);
    /**
     * 根据用户ID 查询其通知内容
     *
     * @param paramMap 参数列表
     * @return
     */
    public List<AoaNoticeList> queryAoaNoticeList(Map<String, Object> paramMap);

    /**
     * 修改通知置顶状态
     *
     * @return
     */
    public Integer updateAoaNoticeForTop(@Param("noticeId") Long noticeId, @Param("isTop") Integer isTop);

    /**
     * 获取总条目数
     *
     * @param paramMap
     * @return
     */
    public Long getNoticeCount(Map<String, Object> paramMap);

    /**
     * 根据ID 查询指定通知
     *
     * @param noticeId 通知ID
     * @return
     */
    public AoaNoticeList queryAoaNoticeListById(Long noticeId);


}