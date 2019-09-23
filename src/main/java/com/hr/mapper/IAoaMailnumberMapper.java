package com.hr.mapper;

import com.hr.entity.AoaMailnumber;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 邮件账号表
 */
@Repository
public interface IAoaMailnumberMapper {

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
    public List<AoaMailnumber> queryAoaMailNumberByMailAccount(Map<String,Object> paramMap);


}