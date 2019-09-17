package com.hr.mapper;

import com.hr.entity.AoaSysMenu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 系统菜单表(权限表)
 */
public interface IAoaSysMenuMapper {

    /**
     * 查询系统权限
     *
     * @param paramMap 查询条件，可填参数(roleId,menuName)
     * @return
     */
    public List<AoaSysMenu> queryAoaSysMenu(Map<String, Object> paramMap);
}