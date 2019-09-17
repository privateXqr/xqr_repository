package com.hr.service;

import com.hr.entity.AoaSysMenu;

import java.util.List;
import java.util.Map;

public interface IAoaSysMenuService {

    public List<AoaSysMenu> queryAoaSysMenu(Map<String, Object> paramMap);
}
