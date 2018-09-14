package com.finance.web.service;

import com.finance.web.model.MenusModel;
import com.finance.web.model.datatable.DataTableReturn;
import com.finance.web.request.CfpCommonRequest;
import com.finance.web.response.MenuTreeResp;
import com.finance.web.response.MenusResp;

import java.util.List;

/**
 * Created by Mignet on 2016/6/22.
 *
 * @Author Libin
 * @Date 2016/6/22
 */
public interface MenuSerivce {

    public DataTableReturn findMenuList(CfpCommonRequest<MenusModel> cfpCommonRequest) throws Exception;

    public List<MenusResp> findMenuAllList(CfpCommonRequest<MenusModel> cfpCommonRequest) throws Exception;

    public MenusModel findMenuOne(MenusModel menusModel) throws Exception;

    public boolean saveMenus(MenusModel menusModel) throws Exception;

    public boolean deleteMenus(List<Integer> iids) throws Exception;

    public List<MenuTreeResp> findMenuTree() throws Exception;

}
