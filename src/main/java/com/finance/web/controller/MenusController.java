package com.finance.web.controller;

import com.finance.annotaions.RequestLogging;
import com.finance.web.model.MenusModel;
import com.finance.web.model.datatable.DataTableReturn;
import com.finance.web.request.CfpCommonRequest;
import com.finance.web.service.MenuSerivce;
import com.finance.web.service.PermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * Created by Mignet on 2016/6/22.
 *菜单管理
 * @Author Libin
 * @Date 2016/6/22
 */
@Controller
@RequestMapping("/menus")
@RequestLogging("菜单列表")
public class MenusController {

    @Resource
    private MenuSerivce menuSerivce;

    @Resource
    private PermissionService permissionService;

    @RequestMapping("/list")
    @RequestLogging("菜单列表-ui")
    public ModelAndView findMenusList() throws Exception{
        ModelAndView modelAndView = new ModelAndView("menus/menu-list");
        CfpCommonRequest<MenusModel> cfpCommonRequest = new CfpCommonRequest<MenusModel>();
        cfpCommonRequest.setParams(new MenusModel());
        cfpCommonRequest.getParams().setParentId(0);
        modelAndView.addObject("parentList",menuSerivce.findMenuAllList(cfpCommonRequest));
        return modelAndView;
    }

    @RequestMapping("/save")
    @RequestLogging("菜单新增或更新")
    public ModelAndView findMenusSave(MenusModel menusModel) throws Exception{
        ModelAndView modelAndView = new ModelAndView("menus/menu-save");
        CfpCommonRequest<MenusModel> cfpCommonRequest = new CfpCommonRequest<MenusModel>();
        cfpCommonRequest.setParams(new MenusModel());
        cfpCommonRequest.getParams().setParentId(0);
        modelAndView.addObject("menu",menuSerivce.findMenuOne(menusModel));
        modelAndView.addObject("parentList",menuSerivce.findMenuAllList(cfpCommonRequest));
        return modelAndView;
    }

    @RequestLogging("更新排序")
    @RequestMapping("/update/sort/{id}/{sort}")
    public Object updateSort(@PathVariable("id") Integer id,@PathVariable("sort") Integer sort) throws Exception{
        if(id>0){
            MenusModel menusModel = new MenusModel();
            menusModel.setSort(sort);
            menusModel.setId(id);
            return menuSerivce.saveMenus(menusModel);
        }
        return false;
    }


    @RequestMapping("/list_json")
    @RequestLogging("菜单列表-AJAX")
    @ResponseBody
    public DataTableReturn findMenusListForData(@RequestBody CfpCommonRequest<MenusModel> cfpCommonRequest) throws Exception{
        return menuSerivce.findMenuList(cfpCommonRequest);
    }


    @RequestMapping("/save_json")
    @RequestLogging("菜单列表-AJAX")
    @ResponseBody
    public Object findMenusSaveForData(MenusModel menusModel) throws Exception{
       return menuSerivce.saveMenus(menusModel);
    }


    @RequestMapping(value = "/delete_json",method = RequestMethod.POST)
    @RequestLogging("菜单批量删除")
    @ResponseBody
    public Object findMenusSaveForData(@RequestParam("iids[]") Integer[] iids) throws Exception{
        if(iids == null || iids.length<=0){
            return false;
        }
        return menuSerivce.deleteMenus(Arrays.asList(iids));
    }

    


}
