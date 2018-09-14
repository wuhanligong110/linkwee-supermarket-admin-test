package com.finance.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.finance.web.dao.MenuMapper;
import com.finance.web.model.MenusModel;
import com.finance.web.model.datatable.DataTableReturn;
import com.finance.web.request.CfpCommonRequest;
import com.finance.web.response.MenuTreeResp;
import com.finance.web.response.MenusResp;
import com.finance.web.service.MenuSerivce;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mignet on 2016/6/22.
 *
 * @Author Libin
 * @Date 2016/6/22
 */
@Service
public class MenuSerivceImpl implements MenuSerivce {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public DataTableReturn findMenuList(CfpCommonRequest<MenusModel> cfpCommonRequest) throws Exception {

        PageHelper.startPage(cfpCommonRequest.getPageIndex(),cfpCommonRequest.getLength());
        Page<MenusResp> menusModelPage = menuMapper.findMenuList(cfpCommonRequest);
        DataTableReturn dataTableReturn = new DataTableReturn();
        dataTableReturn.setDraw(0);
        if(menusModelPage.getTotal()>0){
            dataTableReturn.setRecordsFiltered((int) menusModelPage.getTotal());
            dataTableReturn.setRecordsTotal((int) menusModelPage.getTotal());
            dataTableReturn.setData(menusModelPage.getResult());
        }
        else {
            dataTableReturn.setRecordsFiltered(0);
            dataTableReturn.setRecordsTotal(0);
            dataTableReturn.setData(new ArrayList<Object>());
        }
        return dataTableReturn;
    }

    @Override
    public List<MenusResp> findMenuAllList(CfpCommonRequest<MenusModel> cfpCommonRequest) throws Exception {
        return menuMapper.findMenuList(cfpCommonRequest);
    }

    @Override
    public MenusModel findMenuOne(MenusModel menusModel) throws Exception {
        if(null == menusModel || menusModel.getId() == null){
            return  new MenusModel();
        }
        return menuMapper.findMenuOne(menusModel);
    }

    @Override
    public boolean saveMenus(MenusModel menusModel) throws Exception {
        if(null == menusModel){
            return false;
        }
        int result;
        if(menusModel.getId()!=null && menusModel.getId()>0){
            result= menuMapper.updateMenus(menusModel);
        }
        else{
            result=menuMapper.insertMenu(menusModel);
        }
        return result>0;
    }

    @Override
    public boolean deleteMenus(List<Integer> iids) throws Exception {
        if(null !=iids && !iids.isEmpty()){
            return menuMapper.deleteMenus(iids)>0;
        }
        return false;
    }

    @Override
    public List<MenuTreeResp> findMenuTree() throws Exception {
        CfpCommonRequest<MenusModel> cfpCommonRequest = new CfpCommonRequest<MenusModel>();
        cfpCommonRequest.setParams(new MenusModel());
        cfpCommonRequest.getParams().setIsDisable(0);
        List<MenusResp> menusRespList = menuMapper.findMenuList(cfpCommonRequest);
//        List<MenusResp> menusRespList = menuDao.findMenuList(cfpCommonRequest);
        return getChildMenus(0,menusRespList);
    }

    /**
     * 递归菜单
     * @param menusResps
     * @return
     */
    public List<MenuTreeResp> getChildMenus(Integer parentId, List<MenusResp> menusResps){
        List<MenuTreeResp> result = new ArrayList<MenuTreeResp>();
        MenuTreeResp menuTreeResp =null;
        for(MenusResp menusResp : menusResps){
            if(menusResp.getParentId().equals(parentId)){
                menuTreeResp = new MenuTreeResp();
                menuTreeResp.setId(menusResp.getId());
                menuTreeResp.setMenuIcon(menusResp.getMenuIcon());
                menuTreeResp.setParentId(menusResp.getParentId());
                menuTreeResp.setMenuUrl(menusResp.getMenuUrl());
                menuTreeResp.setMenuName(menusResp.getMenuName());
                menuTreeResp.setPermissionSign(menusResp.getPermissionSign());
                menuTreeResp.setChildList(getChildMenus(menuTreeResp.getId(),menusResps));
                result.add(menuTreeResp);
            }
        }
        return result;
    }
}
