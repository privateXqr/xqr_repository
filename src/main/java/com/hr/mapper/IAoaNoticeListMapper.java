package com.hr.mapper;

import com.hr.entity.AoaNoticeList;

import java.util.List;
import org.apache.ibatis.annotations.Param;

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

}