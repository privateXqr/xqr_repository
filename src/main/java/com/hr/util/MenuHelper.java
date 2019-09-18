package com.hr.util;

import com.hr.entity.AoaSysMenu;
import com.hr.service.IAoaSysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 菜单高级查询帮手
 */
@Component
public class MenuHelper {

    @Autowired
    private IAoaSysMenuService aoaSysMenuService;

    /**
     * 菜单栏 高级查询
     *
     * @param listAoaSysMenu
     * @return
     */
    public List<AoaSysMenu> initMenuWhere(List<AoaSysMenu> listAoaSysMenu, Map<String, Object> paramMap) {

        paramMap.remove("menuName");    //清除掉高级查询条件 菜单名

        List<Long> listMenuIdParent = new ArrayList<>();

        Iterator<AoaSysMenu> aoaSysMenuIterator = listAoaSysMenu.iterator();
        while (aoaSysMenuIterator.hasNext()){
            AoaSysMenu aoaSysMenu = aoaSysMenuIterator.next();

            listMenuIdParent.add(aoaSysMenu.getMenuId());

        }
        //查询所有父级菜单的子级菜单
        for (Long menuId : listMenuIdParent) {
            paramMap.put("parent_id", menuId);

            List<AoaSysMenu> aoaSysMenus = aoaSysMenuService.queryAoaSysMenu(paramMap);

            listAoaSysMenu.addAll(aoaSysMenus);

            paramMap.remove("parent_id");
        }
        return listAoaSysMenu;
    }
}
