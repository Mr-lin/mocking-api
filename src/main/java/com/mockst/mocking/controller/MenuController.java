package com.mockst.mocking.controller;

import com.esnotary.framework.result.APIResult;
import com.esnotary.framework.result.APIResultUtil;
import com.mockst.mocking.config.WebConfigurer;
import com.mockst.mocking.model.menu.TreeMenu;
import com.mockst.mocking.module.menu.entity.MenuEntity;
import com.mockst.mocking.module.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

/**
 * @Auther: zhiwei
 * @Date: 2019/8/28 20:35
 * @Description:
 */
@RestController
@RequestMapping(WebConfigurer.API_BASE_PATH+"/menu")
public class MenuController extends BaseAPIController{


    @Autowired
    private MenuService menuService;

    @RequestMapping("list")
    public APIResult list(){
        List<TreeMenu> list = menuService.findAllMenus();
        return APIResultUtil.returnSuccessResult(list);
    }
}
