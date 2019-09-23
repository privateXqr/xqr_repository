package com.hr.service;

import com.hr.entity.AoaMailnumber;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IAoaMailnumberService {

    /**
     * 验证外部邮箱账号 是否存在
     *
     * @param mailAccount 外部邮箱账号
     * @return
     */
    public AoaMailnumber existsAoaMailnumber(@Param("mailAccount") String mailAccount);

    /**
     * 查询符合条件的邮箱
     *
     * @param paramMap 参数集合
     * @return
     */
    public List<AoaMailnumber> queryAoaMailNumberByMailAccount(Map<String, Object> paramMap);
}
