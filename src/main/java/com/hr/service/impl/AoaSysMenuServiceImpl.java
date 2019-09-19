package com.hr.service.impl;

import com.hr.entity.AoaSysMenu;
import com.hr.mapper.IAoaSysMenuMapper;
import com.hr.service.IAoaSysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AoaSysMenuServiceImpl implements IAoaSysMenuService {

    @Autowired
    private IAoaSysMenuMapper aoaSysMenuMapper;

    @Override
    //@Cacheable("queryAoaSysMenu")
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AoaSysMenu> queryAoaSysMenu(Map<String, Object> paramMap) {
        return aoaSysMenuMapper.queryAoaSysMenu(paramMap);
    }
}
